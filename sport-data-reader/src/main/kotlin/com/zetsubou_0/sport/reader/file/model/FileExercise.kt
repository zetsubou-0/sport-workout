package com.zetsubou_0.sport.reader.file.model

import com.zetsubou_0.sport.core.model.Describable

data class FileExercise (
    override val key: String,
    override var title: String?,
    override var description: String?,
    val muscleGroups: List<String>,
) : Describable