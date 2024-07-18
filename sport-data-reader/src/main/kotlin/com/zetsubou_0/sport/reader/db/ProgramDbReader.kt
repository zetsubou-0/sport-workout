package com.zetsubou_0.sport.reader.db

import com.zetsubou_0.sport.core.model.Program
import com.zetsubou_0.sport.core.model.ProgramParameters
import com.zetsubou_0.sport.core.service.DataReader
import com.zetsubou_0.sport.reader.service.ProgramReader

class ProgramDbReader (val reader: DataReader) : ProgramReader {
    override fun readProgram(programParameters: ProgramParameters): Program? {
        TODO("Not yet implemented")
    }
}