package com.example.mentaldiary.di


import com.example.domain.usecase.GetImagesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetImagesUseCase> { GetImagesUseCase(get()) }
}