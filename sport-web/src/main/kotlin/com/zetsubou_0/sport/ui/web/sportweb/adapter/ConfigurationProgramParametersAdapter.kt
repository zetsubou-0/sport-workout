package com.zetsubou_0.sport.ui.web.sportweb.adapter

import com.zetsubou_0.sport.core.model.ProgramParameters
import com.zetsubou_0.sport.core.service.ProgramParametersAdapter
import com.zetsubou_0.sport.ui.web.sportweb.service.ConfigurationService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ConfigurationProgramParametersAdapter : ProgramParametersAdapter<ConfigurationService> {
    override fun adapt(parameters: ConfigurationService): ProgramParameters? {
        return ProgramParameters(
            name = parameters.name,
            locale = Locale.of(parameters.locale),
            counter = parameters.counter,
        )
    }
}