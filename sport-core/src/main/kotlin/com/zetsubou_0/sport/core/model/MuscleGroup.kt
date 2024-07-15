package com.zetsubou_0.sport.core.model

data class MuscleGroup(
    override val key: String,
    override var title: String?,
    override var description: String?,
    var subGroups: List<MuscleGroup>?,
) : Describable {
}
