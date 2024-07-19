package com.zetsubou_0.sport.ui.web.sportweb.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ConfigurationService (
    @Value("\${sport.workout.name:}") val name: String,
    @Value("\${sport.workout.locale:}") val locale: String,
    @Value("\${sport.workout.counter:0}") val counter: Int,
    @Value("\${sport.workout.source:file}") val source: String,
) {
}