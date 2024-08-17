package com.zetsubou_0.i18n.sporti18n.rest

import com.zetsubou_0.i18n.sporti18n.model.Translations
import com.zetsubou_0.i18n.sporti18n.service.TranslationsService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TranslationsController(
    val translationsService: TranslationsService
) {
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/i18n/{lang}/{dictionary}.json")
    fun getTranslations(
        @PathVariable lang: String,
        @PathVariable dictionary: String,
    ): Translations {
        return translationsService.getTranslations(lang, dictionary)
    }
}