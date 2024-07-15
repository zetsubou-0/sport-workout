package com.zetsubou_0.sport.core.model

data class Exercise (
    override val key: String,
    override var title: String?,
    override var description: String?,
    var muscleGroups: List<MuscleGroup>,
) : Describable