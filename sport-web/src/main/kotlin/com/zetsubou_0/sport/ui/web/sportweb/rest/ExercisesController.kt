package com.zetsubou_0.sport.ui.web.sportweb.rest

import com.zetsubou_0.sport.ui.web.sportweb.dto.ExercisesDto
import com.zetsubou_0.sport.ui.web.sportweb.service.AppDataService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ExercisesController(val appDataService: AppDataService) {

    @GetMapping(
        "/"
    )
    fun exercises(model: Model): String {
        val appData = appDataService.getAppData()
        model["title"] =  appData?.program?.title
        model["language"] = appData?.programParameters?.locale.toString()
        model["items"] = ExercisesDto(appData?.program?.items ?: listOf()).items
        return "exercises"
    }
}