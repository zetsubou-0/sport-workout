package com.zetsubou_0.i18n.sporti18n.model

data class Translations (
    val language: String,
    val dictionaryName: String,
    val data: Map<String, String>
)