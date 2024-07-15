package com.zetsubou_0.sport.ui.web.sportweb.service

import com.zetsubou_0.sport.core.model.AppData
import com.zetsubou_0.sport.core.service.ProgramParametersAdapter
import com.zetsubou_0.sport.workout.data.reader.file.FileReader
import org.springframework.stereotype.Service

@Service
class AppDataService(
    val configurationService: ConfigurationService,
    var adapter: ProgramParametersAdapter<ConfigurationService>,
) {
    fun getAppData(): AppData? {
        return FileReader<ConfigurationService>().read(adapter, configurationService)
    }
}