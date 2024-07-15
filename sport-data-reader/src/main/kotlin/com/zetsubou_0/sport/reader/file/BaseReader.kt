package com.zetsubou_0.sport.workout.data.reader.file

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zetsubou_0.sport.core.model.Describable
import de.comahe.i18n4k.Locale
import de.comahe.i18n4k.messages.MessageBundle
import de.comahe.i18n4k.messages.MessageBundleEntry
import de.comahe.i18n4k.messages.provider.MessagesProviderViaResource
import java.io.InputStream

abstract class BaseReader<T : Describable>(
    private val gson: Gson,
    private val name: String,
    private val locale: Locale,
    private val messageBundle: MessageBundle,
    private val messageFn: (String) -> MessageBundleEntry?,
    private val type: TypeToken<List<T>>
) {
    fun read(): Map<String, T> {
//        loadLocalizations()
        return ExerciseFileReader::class.java.getResourceAsStream("${Constants.immutableData}/${name}.json")
            .use { if (it != null) readMap(it) else mapOf() }
    }

    private fun loadLocalizations() {
        messageBundle.registerTranslation(MessagesProviderViaResource(
            pathToResource = "${messageBundle.messageBundlePackage}/${messageBundle.messageBundleName}_${locale}.i18n4k.txt"
        ))
    }

    private fun readMap(inputStream: InputStream): Map<String, T> {
        return gson.fromJson(inputStream.reader(), type)
            .map(this::localize)
            .associateBy { it.key }
    }

    private fun localize(describable: T): T {
        val title = describable.title
        if (title != null) {
            describable.title = messageFn(title).toString()
        }
        val description = describable.description
        if (description != null) {
            describable.description = messageFn(description).toString()
        }
        return describable
    }

}