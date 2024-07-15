package com.zetsubou_0.sport.core.service

import com.zetsubou_0.sport.core.model.ProgramParameters
import de.comahe.i18n4k.config.I18n4kConfigDefault
import de.comahe.i18n4k.i18n4k

class I18nService {
    fun init(programParameters: ProgramParameters) {
        val i18n4kConfig = I18n4kConfigDefault()
        i18n4kConfig.locale = programParameters.locale
        i18n4k = i18n4kConfig
    }
}