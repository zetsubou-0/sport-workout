package com.zetsubou_0.sport.reader.factory

import com.zetsubou_0.sport.core.service.DataReader
import com.zetsubou_0.sport.reader.db.DbReader
import com.zetsubou_0.sport.reader.file.FileReader

class DataReaderFactory {
    companion object {

        private val cache: MutableMap<DataReader.ReaderType, DataReader> = mutableMapOf()

        fun create(type: DataReader.ReaderType): DataReader = cache.computeIfAbsent(type, this::getDataReaderByType)

        private fun getDataReaderByType(type: DataReader.ReaderType): DataReader =
            when(type) {
                DataReader.ReaderType.FILE -> FileReader()
                DataReader.ReaderType.DB -> DbReader()
            }
    }
}