package com.example.domain.base

interface SuspendUseCase<in INPUT, out OUTPUT> {

    suspend fun execute(params: INPUT? = null): OUTPUT
}