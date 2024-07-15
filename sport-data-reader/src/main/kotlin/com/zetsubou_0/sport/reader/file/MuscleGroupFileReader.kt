package com.zetsubou_0.sport.workout.data.reader.file

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zetsubou_0.sport.core.i18n.MuscleGroupText
import com.zetsubou_0.sport.core.model.MuscleGroup
import de.comahe.i18n4k.Locale

class MuscleGroupFileReader(gson: Gson, locale: Locale) : BaseReader<MuscleGroup>(
    gson,
    "muscle-groups",
    locale,
    MuscleGroupText,
    MuscleGroupText::getEntryByKey,
    object : TypeToken<List<MuscleGroup>>() {}
) {
}