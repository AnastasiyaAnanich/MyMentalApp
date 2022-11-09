package com.example.mentaldiary.di

import androidx.room.Room
import com.example.data.RetrofitCreator
import com.example.data.converters.UserEntityToUserDtoConverter
import com.example.data.converters.UserToUserDtoConverter
import com.example.data.converters.UserToUserEntityConvertor
import com.example.data.repository.NetworkRepositoryImpl
import com.example.data.storage.network.NetworkService
import com.example.data.storage.network.NetworkStorage
import com.example.data.storage.network.NetworkStorageImpl
import com.example.data.storage.network.database.DataBaseUserStorage
import com.example.data.storage.network.database.DataBaseUserStorageImpl
import com.example.data.storage.network.database.UserDataBase
import com.example.domain.repository.NetworkRepository
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { GsonBuilder().serializeNulls().create() }

    val creator = RetrofitCreator()

    single { creator.createService(get(), NetworkService::class.java) as NetworkService }

    single {
        Room.databaseBuilder(androidApplication(), UserDataBase::class.java, "user_data_base")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<UserDataBase>().userDao() }


    single<NetworkStorage> {
        NetworkStorageImpl(get())
    }

    single<DataBaseUserStorage> { DataBaseUserStorageImpl(get()) }


    single<NetworkRepository> {
        NetworkRepositoryImpl(get(), get(), get(), get(), get())
    }

    factory { UserToUserDtoConverter() }

    factory { UserEntityToUserDtoConverter() }

    factory { UserToUserEntityConvertor() }
}
