package com.zetsubou_0.i18n.sporti18n.rest

import com.zetsubou_0.i18n.sporti18n.model.Translations
import com.zetsubou_0.i18n.sporti18n.service.TranslationsService
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

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

    @PostMapping("/i18n/upload/{lang}/{dictionary}.json")
    fun uploadTranslations(
        @PathVariable lang: String,
        @PathVariable dictionary: String,
        @RequestParam file: MultipartFile,
    ) {
        translationsService.uploadTranslations(lang, dictionary, file.bytes)
    }
}