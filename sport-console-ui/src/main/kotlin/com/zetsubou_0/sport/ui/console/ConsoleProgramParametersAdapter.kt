package com.zetsubou_0.sport.workout.ui.console

import com.zetsubou_0.sport.core.model.ProgramParameters
import com.zetsubou_0.sport.core.service.I18nService
import com.zetsubou_0.sport.core.service.ProgramParametersAdapter
import de.comahe.i18n4k.Locale

class ConsoleProgramParametersAdapter : ProgramParametersAdapter<Array<String>> {

    private val parameterName = "name"
    private val parameterLocale = "locale"
    private val parameterCounter = "counter"

    override fun adapt(parameters: Array<String>): ProgramParameters? {
        val argsMap = parameters.toList().chunked(2).associate { it[0].replace("-", "") to it[1] }
        val name = argsMap[parameterName]
        val localeString = argsMap[parameterLocale] ?: "en"
        val locale = Locale.of(localeString)
        val counter = argsMap[parameterCounter]?.toInt()
        if (name == null || counter == null) {
            return null
        }
        val programParameters = ProgramParameters(name, locale, counter)
        I18nService().init(programParameters)
        return programParameters
    }
}