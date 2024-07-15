package com.zetsubou_0.sport.workout.data.reader.file

import com.google.gson.Gson
import com.zetsubou_0.sport.core.model.*
import com.zetsubou_0.sport.core.service.DataReader
import com.zetsubou_0.sport.core.service.ProgramParametersAdapter
import com.zetsubou_0.sport.reader.file.model.FileExercise
import com.zetsubou_0.sport.workout.data.reader.file.model.FileProgram

class FileReader<T> : DataReader<T> {

    private val gson = Gson()

    override fun read(programParametersAdapter: ProgramParametersAdapter<T>, parameters: T): AppData? {
        val programParameters = programParametersAdapter.adapt(parameters) ?: return null
        val fileProgram =
            FileReader::class.java.getResourceAsStream("${Constants.basePath}/programs/${programParameters.name}.json")
                .use { inputStream ->
                    if (inputStream != null) gson.fromJson(
                        inputStream.reader(),
                        FileProgram::class.java
                    ) else null
                }
        val program = createProgram(programParameters, fileProgram)
        return if (program != null) AppData(program, programParameters) else null
    }

    private fun createProgram(programParameters: ProgramParameters, fileProgram: FileProgram?): Program? {
        if (fileProgram == null) {
            return null
        }
        val exercises = ExerciseFileReader(gson, programParameters.locale).read()
        val muscleGroups = MuscleGroupFileReader(gson, programParameters.locale).read()
        return Program(fileProgram.title, fileProgram.items.map{ createItem(programParameters, it, exercises, muscleGroups) }.filterNotNull())
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
        val cycles = fileProgramItem.cycle?.map { createItem(programParameters, it, exercises, muscleGroups) }?.filterNotNull()
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