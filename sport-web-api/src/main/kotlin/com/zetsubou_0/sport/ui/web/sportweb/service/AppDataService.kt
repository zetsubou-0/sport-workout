package com.zetsubou_0.sport.ui.web.sportweb.service

import com.zetsubou_0.sport.core.model.AppData
import com.zetsubou_0.sport.core.service.ProgramParametersAdapter
import com.zetsubou_0.sport.reader.service.AppReader
import org.springframework.stereotype.Service

@Service
class AppDataService(
    val configurationService: ConfigurationService,
    var adapter: ProgramParametersAdapter<ConfigurationService>,
) {
    fun getAppData(): AppData? {
        return getAppData(null, null)
    }

    fun getAppData(exerciseName: String?, counter: Int?): AppData? {
        val programParameters = adapter.adapt(configurationService)
        if (exerciseName != null) {
            programParameters?.name = exerciseName
        }
        if (counter != null) {
            programParameters?.counter = counter
        }
        return AppReader().readApp(programParameters)
    }
}