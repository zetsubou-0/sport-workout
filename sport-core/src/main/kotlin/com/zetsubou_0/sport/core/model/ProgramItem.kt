package com.zetsubou_0.sport.core.model

data class ProgramItem (
    val exercise: Exercise,
    var count: Int,
    var repeatCount: Int,
    val repetitionIncrement: Int,
    var duration: Int,
    val durationIncrement: Int,
    var cycle: List<ProgramItem>?,
)