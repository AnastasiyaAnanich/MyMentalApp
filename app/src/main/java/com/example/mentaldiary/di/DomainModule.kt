package com.example.mentaldiary.di


import com.example.domain.usecase.GetUsersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUsersUseCase> { GetUsersUseCase(get()) }
}