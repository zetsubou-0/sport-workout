package com.zetsubou_0.sport.ui.web.sportweb.dto

import com.zetsubou_0.sport.core.model.ProgramItem

class ExercisesDto(
    val title: String?,
    val locale: String?,
    programItems: List<ProgramItem>
) {
    val items: List<ExercisesDtoItem> = programItems.map { ExercisesDtoItem(
        it.exercise.title,
        it.exercise.description,
        it.exercise.muscleGroups.map { it.title }.filterNotNull(),
        it.count,
        it.repeatCount,
        it.duration,
    ) }

    data class ExercisesDtoItem(
        val title: String?,
        val description: String?,
        var muscleGroups: List<String>,
        val count: Int,
        val repeatCount: Int,
        val duration: Int,
    )
}