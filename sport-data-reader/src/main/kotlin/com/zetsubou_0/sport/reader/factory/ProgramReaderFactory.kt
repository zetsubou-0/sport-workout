package com.zetsubou_0.sport.reader.factory

import com.zetsubou_0.sport.core.service.DataReader
import com.zetsubou_0.sport.reader.db.ProgramDbReader
import com.zetsubou_0.sport.reader.file.ProgramFileReader
import com.zetsubou_0.sport.reader.service.ProgramReader

class ProgramReaderFactory {
    companion object {

        private val cache: MutableMap<DataReader.ReaderType, ProgramReader> = mutableMapOf()

        fun create(type: DataReader.ReaderType, reader: DataReader): ProgramReader =
            cache.computeIfAbsent(type) { getProgramReaderByType(it, reader) }

        private fun getProgramReaderByType(type: DataReader.ReaderType, reader: DataReader): ProgramReader =
            when(type) {
                DataReader.ReaderType.FILE -> ProgramFileReader(reader)
                DataReader.ReaderType.DB -> ProgramDbReader(reader)
            }
    }
}