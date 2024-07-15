package com.zetsubou_0.sport.ui.web.sportweb.dto

import com.zetsubou_0.sport.core.model.ProgramItem

class ExercisesDto(programItems: List<ProgramItem>) {

    val items: List<ExercisesDtoItem> = programItems.map { ExercisesDtoItem(
        it.exercise.title,
        it.exercise.description,
        it.exercise.muscleGroups.map { it.title }.filterNotNull(),
        it.count,
        it.count > 0,
        it.repeatCount,
        it.repeatCount > 0,
        it.duration,
        it.duration > 0,
    ) }

    data class ExercisesDtoItem(
        val title: String?,
        val description: String?,
        var muscleGroups: List<String>,
        val count: Int,
        val hasCount: Boolean,
        val repeatCount: Int,
        val hasRepeatCount: Boolean,
        val duration: Int,
        val hasDuration: Boolean,
    )
}