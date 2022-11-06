package com.example.domain.base

interface Converter<INPUT, OUTPUT> {
    fun invoke(params: INPUT): OUTPUT
}