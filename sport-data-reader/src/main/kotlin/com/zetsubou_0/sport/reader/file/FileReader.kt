package com.zetsubou_0.sport.reader.file

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zetsubou_0.sport.core.service.DataReader

open class FileReader : DataReader {

    companion object {
        private val gson = Gson()
    }

    override fun <T, R> read(config: DataReader.ReaderConfig<T>): R? {
        if (config.source !is String && config.modelType !is TypeToken<*>) {
            return null
        }
        return FileReader::class.java.getResourceAsStream(config.source as String)
            .use { gson.fromJson(it?.reader(), config.modelType as TypeToken<R> ) }
    }

}