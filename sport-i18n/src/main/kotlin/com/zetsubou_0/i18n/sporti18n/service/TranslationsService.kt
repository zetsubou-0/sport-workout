package com.zetsubou_0.i18n.sporti18n.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zetsubou_0.i18n.sporti18n.entry.Language
import com.zetsubou_0.i18n.sporti18n.entry.Translation
import com.zetsubou_0.i18n.sporti18n.model.Translations
import com.zetsubou_0.i18n.sporti18n.model.UploadedTranslations
import com.zetsubou_0.i18n.sporti18n.repository.LanguageRepository
import com.zetsubou_0.i18n.sporti18n.repository.TranslationRepository
import org.springframework.stereotype.Service
import java.io.InputStreamReader

@Service
class TranslationsService(
    val translationRepository: TranslationRepository, private val languageRepository: LanguageRepository
) {

    private val gson = Gson()

    fun getTranslations(lang: String, dictionary: String): Translations {
        val translations = translationRepository.findAllByNameAndLanguage_Language(dictionary, lang)
            .associate { it.key to it.translation }
        return Translations(
            lang,
            dictionary,
            translations
        )
    }

    fun uploadTranslations(lang: String, dictionary: String, content: ByteArray) {
        val language = languageRepository.findFirstByLanguage(lang) ?: languageRepository.save(Language(null, lang))
        val translations = gson.fromJson(
            InputStreamReader(content.inputStream()),
            object : TypeToken<List<UploadedTranslations>>() {},
        ).map { Translation(null, language, dictionary, it.key, it.value) }
        translationRepository.saveAll(translations)
    }
}