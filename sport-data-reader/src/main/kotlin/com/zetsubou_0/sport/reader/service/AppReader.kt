package com.zetsubou_0.sport.reader.service

import com.zetsubou_0.sport.core.model.AppData
import com.zetsubou_0.sport.core.model.ProgramParameters
import com.zetsubou_0.sport.reader.factory.DataReaderFactory
import com.zetsubou_0.sport.reader.factory.ProgramReaderFactory

class AppReader {
    fun readApp(programParameters: ProgramParameters?): AppData? {
        if (programParameters == null) {
            println("Program parameters is null")
            return null
        }
        val reader = DataReaderFactory.create(programParameters.source)
        val program = ProgramReaderFactory.create(programParameters.source, reader).readProgram(programParameters)
        if (program == null) {
            println("Program is null")
            return null
        }
        return AppData(program, programParameters)
    }
}