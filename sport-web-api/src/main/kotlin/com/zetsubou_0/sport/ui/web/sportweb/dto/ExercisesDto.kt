package com.zetsubou_0.sport.ui.web.sportweb.dto

import com.zetsubou_0.sport.core.model.ProgramItem

class ExercisesDto(
    val title: String?,
    val locale: String?,
    programItems: List<ProgramItem>
) {
    val items: List<ExercisesDtoItem> = programItems.map(this::createDtoFromItem)

    private fun createDtoFromItem(programItem: ProgramItem): ExercisesDtoItem {
        return ExercisesDtoItem(
            programItem.exercise.title,
            programItem.exercise.description,
            programItem.exercise.muscleGroups.map { it.title }.filterNotNull(),
            programItem.count,
            programItem.repeatCount,
            programItem.duration,
            if (programItem.cycle != null) programItem.cycle?.map(this::createDtoFromItem) else listOf()
        )
    }

    data class ExercisesDtoItem(
        val title: String?,
        val description: String?,
        var muscleGroups: List<String>,
        val count: Int,
        val repeatCount: Int,
        val duration: Int,
        val cycle: List<ExercisesDtoItem>?,
    )
}