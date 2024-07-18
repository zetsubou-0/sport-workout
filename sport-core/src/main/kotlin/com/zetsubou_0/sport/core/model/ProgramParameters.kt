package com.zetsubou_0.sport.core.model

import com.zetsubou_0.sport.core.service.DataReader
import de.comahe.i18n4k.Locale

data class ProgramParameters(
    var name: String,
    val locale: Locale = Locale.ENGLISH,
    val counter: Int = 0,
    var source: DataReader.ReaderType = DataReader.ReaderType.FILE,
)
