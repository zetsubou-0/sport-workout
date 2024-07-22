package com.zetsubou_0.sport.ui.web.sportweb.rest

import com.zetsubou_0.sport.ui.web.sportweb.dto.ExercisesDto
import com.zetsubou_0.sport.ui.web.sportweb.service.AppDataService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
@RestController
class ExercisesApiController(val appDataService: AppDataService) {

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/exercises.json")
    fun exercises(): ExercisesDto {
        val appData = appDataService.getAppData()
        return ExercisesDto(
            appData?.program?.title,
            appData?.programParameters?.locale.toString(),
            appData?.program?.items ?: listOf()
        )
    }
}

