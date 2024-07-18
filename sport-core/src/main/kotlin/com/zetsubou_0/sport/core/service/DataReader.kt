package com.zetsubou_0.sport.core.service

interface DataReader {
    fun <T, R> read(config: ReaderConfig<T>): R?

    data class ReaderConfig<T> (
        val source: T,
        val modelType: Any,
    )

    enum class ReaderType {
        FILE, DB;
    }
}