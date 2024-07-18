package com.zetsubou_0.sport.reader.file

import com.google.gson.reflect.TypeToken
import com.zetsubou_0.sport.core.model.*
import com.zetsubou_0.sport.core.service.DataReader
import com.zetsubou_0.sport.reader.file.model.FileExercise
import com.zetsubou_0.sport.reader.service.ProgramReader
import com.zetsubou_0.sport.workout.data.reader.file.Constants
import com.zetsubou_0.sport.workout.data.reader.file.FileMapReader
import com.zetsubou_0.sport.workout.data.reader.file.model.FileProgram

class ProgramFileReader (
    val reader: DataReader,
) : ProgramReader {
    override fun readProgram(programParameters: ProgramParameters): Program? {
        val fileProgram = reader.read<String, FileProgram>(
            DataReader.ReaderConfig(
                "${Constants.basePath}/programs/${programParameters.name}.json",
                object : TypeToken<FileProgram>() {}
            ))
        if (fileProgram == null) {
            return null
        }
        val exercises = FileMapReader.exerciseReader(reader, programParameters.locale).read()
        val muscleGroups = FileMapReader.muscleGroupsReader(reader, programParameters.locale).read()
        return Program(
            fileProgram.title,
            fileProgram.items.map { createItem(programParameters, it, exercises, muscleGroups) }.filterNotNull()
        )
    }

    private fun createItem(
        programParameters: ProgramParameters,
        fileProgramItem: FileProgram.FileProgramItem,
        exercises: Map<String, FileExercise>,
        muscleGroups: Map<String, MuscleGroup>
    ): ProgramItem? {
        val exercise = createExercise(fileProgramItem.id, exercises, muscleGroups) ?: return null
        var count = 0
        if (fileProgramItem.repetitionIncrement > 0) {
            count = programParameters.counter.floorDiv(fileProgramItem.repetitionIncrement)
        }
        var duration = 0
        if (fileProgramItem.durationIncrement > 0) {
            duration = programParameters.counter.floorDiv(fileProgramItem.durationIncrement)
        }
        val cycles =
            fileProgramItem.cycle?.map { createItem(programParameters, it, exercises, muscleGroups) }?.filterNotNull()
        return ProgramItem(
            exercise,
            count,
            fileProgramItem.repeatCount,
            fileProgramItem.repetitionIncrement,
            duration,
            fileProgramItem.durationIncrement,
            cycles
        )
    }

    private fun createExercise(
        exerciseId: String,
        exercises: Map<String, FileExercise>,
        muscleGroups: Map<String, MuscleGroup>
    ): Exercise? {
        val exercise = exercises[exerciseId] ?: return null
        return Exercise(
            exercise.key,
            exercise.title,
            exercise.description,
            exercise.muscleGroups.map { createMuscleGroups(it, muscleGroups) }.filterNotNull()
        )
    }

    private fun createMuscleGroups(muscleGroupId: String, muscleGroups: Map<String, MuscleGroup>): MuscleGroup? {
        val muscleGroupFromMap = muscleGroups[muscleGroupId] ?: return null
        return MuscleGroup(
            muscleGroupFromMap.key,
            muscleGroupFromMap.title,
            muscleGroupFromMap.description,
            muscleGroupFromMap.subGroups?.map { createMuscleGroups(it.key, muscleGroups) }?.filterNotNull()
        )
    }
}