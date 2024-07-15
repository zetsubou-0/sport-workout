package com.zetsubou_0.sport.core.service

import com.zetsubou_0.sport.core.model.AppData

interface DataReader<T> {
    fun read(programParametersAdapter: ProgramParametersAdapter<T>, parameters: T): AppData?
}