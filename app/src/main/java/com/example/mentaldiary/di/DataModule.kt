package com.example.mentaldiary.di

import com.example.data.RetrofitCreator
import com.example.data.converters.BookToBookDtoConverter
import com.example.data.repository.NetworkRepositoryImpl
import com.example.data.storage.network.NetworkService
import com.example.data.storage.network.NetworkStorage
import com.example.data.storage.network.NetworkStorageImpl
import com.example.domain.repository.NetworkRepository
import com.google.gson.GsonBuilder
import org.koin.dsl.module

val dataModule = module {

    single { GsonBuilder().serializeNulls().create() }
    val creator = RetrofitCreator()
    single { creator.createService(get(), NetworkService::class.java) as NetworkService }

    single<NetworkStorage> {
        NetworkStorageImpl(get())
    }
    single<NetworkRepository> {
        NetworkRepositoryImpl(get(),get())
    }

    factory { BookToBookDtoConverter() }
}