package com.zetsubou_0.sport.ui.console

import com.zetsubou_0.sport.reader.service.AppReader
import com.zetsubou_0.sport.workout.ui.console.ConsoleProgramParametersAdapter
import com.zetsubou_0.sport.workout.ui.console.ConsoleView

fun main(args: Array<String>) {
    val programParameters = ConsoleProgramParametersAdapter().adapt(args)
    val appData =  AppReader().readApp(programParameters)
    if (appData != null) {
        ConsoleView().print(appData)
    }
}