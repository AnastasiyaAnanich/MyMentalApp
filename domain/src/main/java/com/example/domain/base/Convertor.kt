package com.example.domain.base

interface Convertor<INPUT, OUTPUT> {

    fun invoke(params: INPUT): OUTPUT
}