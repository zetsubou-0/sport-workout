package com.zetsubou_0.sport.workout.data.reader.file.model

data class FileProgram(
    val title: String,
    val items: List<FileProgramItem>
) {
    data class FileProgramItem(
        val id: String,
        var count: Int,
        var repeatCount: Int,
        val repetitionIncrement: Int,
        var duration: Int,
        val durationIncrement: Int,
        var cycle: List<FileProgramItem>?,
    )
}
