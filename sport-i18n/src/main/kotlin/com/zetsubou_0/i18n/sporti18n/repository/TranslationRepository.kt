package com.zetsubou_0.i18n.sporti18n.repository

import com.zetsubou_0.i18n.sporti18n.entry.Translation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TranslationRepository : JpaRepository<Translation, Long> {
    fun findAllByNameAndLanguage_Language(name: String, language: String): List<Translation>
}