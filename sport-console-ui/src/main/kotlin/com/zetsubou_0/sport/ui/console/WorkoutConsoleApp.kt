package com.zetsubou_0.sport.ui.console

import com.zetsubou_0.sport.workout.data.reader.file.FileReader
import com.zetsubou_0.sport.workout.ui.console.ConsoleProgramParametersAdapter
import com.zetsubou_0.sport.workout.ui.console.ConsoleView

fun main(args: Array<String>) {
    val appData = FileReader<Array<String>>().read(
        ConsoleProgramParametersAdapter(),
        args
    )
    if (appData == null) {
        println("appData is null")
        return
    }
    ConsoleView().print(appData)
}