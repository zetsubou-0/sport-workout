package com.zetsubou_0.sport.reader.service

import com.zetsubou_0.sport.core.model.Program
import com.zetsubou_0.sport.core.model.ProgramParameters

interface ProgramReader {
    fun readProgram(programParameters: ProgramParameters): Program?
}