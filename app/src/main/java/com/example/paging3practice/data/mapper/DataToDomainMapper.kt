package com.example.paging3practice.data.mapper

interface DataToDomainMapper<T> {

    fun toModel(): T
}

fun <T> List<DataToDomainMapper<T>>.toModel(): List<T> = map { it.toModel() }