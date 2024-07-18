package com.zetsubou_0.sport.workout.data.reader.file

import com.google.gson.reflect.TypeToken
import com.zetsubou_0.sport.core.i18n.ExerciseText
import com.zetsubou_0.sport.core.i18n.MuscleGroupText
import com.zetsubou_0.sport.core.model.Describable
import com.zetsubou_0.sport.core.model.MuscleGroup
import com.zetsubou_0.sport.core.service.DataReader
import com.zetsubou_0.sport.reader.file.model.FileExercise
import de.comahe.i18n4k.Locale
import de.comahe.i18n4k.messages.MessageBundle
import de.comahe.i18n4k.messages.MessageBundleEntry

class FileMapReader<T : Describable> (
    private val reader: DataReader,
    private val name: String,
    private val locale: Locale,
    private val messageBundle: MessageBundle,
    private val messageFn: (String) -> MessageBundleEntry?,
    private val type: TypeToken<List<T>>
) {

    companion object {
        fun exerciseReader(reader: DataReader, locale: Locale): FileMapReader<FileExercise> {
            return FileMapReader(
                reader,
                "exercises",
                locale,
                ExerciseText,
                ExerciseText::getEntryByKey,
                object : TypeToken<List<FileExercise>>() {}
            )
        }

        fun muscleGroupsReader(reader: DataReader, locale: Locale): FileMapReader<MuscleGroup> {
            return FileMapReader(
                reader,
                "muscle-groups",
                locale,
                MuscleGroupText,
                MuscleGroupText::getEntryByKey,
                object : TypeToken<List<MuscleGroup>>() {}
            )
        }
    }

    fun read(): Map<String, T> {
        val config = DataReader.ReaderConfig("${Constants.immutableData}/${name}.json", type)
        return reader.read<String, List<T>>(config)
            ?.map(this::localize)
            ?.associateBy { it.key }
            ?: mapOf()
    }

    private fun localize(describable: T): T {
        val title = describable.title
        if (title != null) {
            describable.title = messageFn(title).toString()
        }
        val description = describable.description
        if (description != null) {
            describable.description = messageFn(description).toString()
        }
        return describable
    }
}