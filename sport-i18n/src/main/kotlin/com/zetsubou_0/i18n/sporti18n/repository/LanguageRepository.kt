package com.zetsubou_0.i18n.sporti18n.repository

import com.zetsubou_0.i18n.sporti18n.entry.Language
import org.springframework.data.jpa.repository.JpaRepository

interface LanguageRepository : JpaRepository<Language, Long> {
    fun findFirstByLanguage(language: String): Language?
}