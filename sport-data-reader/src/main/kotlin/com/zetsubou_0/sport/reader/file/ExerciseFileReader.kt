package com.zetsubou_0.sport.workout.data.reader.file

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zetsubou_0.sport.core.i18n.ExerciseText
import com.zetsubou_0.sport.reader.file.model.FileExercise
import de.comahe.i18n4k.Locale

class ExerciseFileReader(gson: Gson, locale: Locale) : BaseReader<FileExercise>(
    gson,
    "exercises",
    locale,
    ExerciseText,
    ExerciseText::getEntryByKey,
    object : TypeToken<List<FileExercise>>() {}
) {
}