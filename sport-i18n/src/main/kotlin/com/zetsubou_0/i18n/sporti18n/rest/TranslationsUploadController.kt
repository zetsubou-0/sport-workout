package com.zetsubou_0.i18n.sporti18n.rest

import com.zetsubou_0.i18n.sporti18n.service.TranslationsService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class TranslationsUploadController (
    val translationsService: TranslationsService

) {
    @PostMapping("/i18n/upload/json/{lang}/{dictionary}.json")
    fun uploadTranslations(
        @PathVariable lang: String,
        @PathVariable dictionary: String,
        @RequestParam file: MultipartFile,
    ) {
        translationsService.uploadJsonTranslations(lang, dictionary, file.bytes)
    }

}