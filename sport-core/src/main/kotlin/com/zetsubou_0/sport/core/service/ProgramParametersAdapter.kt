package com.zetsubou_0.sport.core.service

import com.zetsubou_0.sport.core.model.ProgramParameters

interface ProgramParametersAdapter<T> {
    fun adapt(parameters: T): ProgramParameters?
}