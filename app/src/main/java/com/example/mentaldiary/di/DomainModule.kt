package com.example.mentaldiary.di

import com.example.domain.usecase.GetBookUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetBookUseCase> { GetBookUseCase(get()) }
}