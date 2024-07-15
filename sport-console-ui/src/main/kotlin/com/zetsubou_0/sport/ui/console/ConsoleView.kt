package com.zetsubou_0.sport.workout.ui.console

import com.zetsubou_0.sport.core.model.AppData
import com.zetsubou_0.sport.core.model.ProgramItem
import com.zetsubou_0.sport.ui.i18n.ConsoleText

class ConsoleView {

    fun print(appData: AppData) {
        val program = appData.program
        println(program.title)
        println()
        program.items.forEach(this::printProgramItem)
        println(ConsoleText.console_total(program.items.size))
        println()
    }

    private fun printProgramItem(programItem: ProgramItem) {
        if ((programItem.cycle?.size ?: 0) > 0) {
            println(ConsoleText.console_repeat_cycle(programItem.repeatCount))
            programItem.cycle?.forEach(this::printProgramItem)
            return
        }
        val exercise = programItem.exercise
        println("${exercise.title} ${exercise.muscleGroups.map { it.title }}")
        println("${exercise.description}")
        if (programItem.count > 0) {
            println(ConsoleText.console_count(programItem.count))
        }
        if (programItem.repeatCount > 0) {
            println(ConsoleText.console_repeat(programItem.repeatCount))
        }
        if (programItem.duration > 0) {
            println(ConsoleText.console_duration(programItem.duration))
        }
        println()
    }
}