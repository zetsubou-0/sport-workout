package com.zetsubou_0.sport.core.model

import de.comahe.i18n4k.Locale

data class ProgramParameters(
    var name: String,
    val locale: Locale = Locale.ENGLISH,
    val counter: Int = 0,
)
