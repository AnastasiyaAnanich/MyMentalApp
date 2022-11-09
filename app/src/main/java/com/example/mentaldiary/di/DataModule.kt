package com.example.mentaldiary.di

import androidx.room.Room
import com.example.data.RetrofitCreator
import com.example.data.converters.ImagesEntityToImagesDtoConverter
import com.example.data.converters.ImagesToImagesDtoConverter
import com.example.data.converters.ImagesToImagesEntityConvertor
import com.example.data.repository.NetworkRepositoryImpl
import com.example.data.storage.network.NetworkService
import com.example.data.storage.network.NetworkStorage
import com.example.data.storage.network.NetworkStorageImpl
import com.example.data.storage.network.database.DataBaseImagesStorage
import com.example.data.storage.network.database.DataBaseImagesStorageImpl
import com.example.data.storage.network.database.ImagesDataBase
import com.example.domain.repository.NetworkRepository
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { GsonBuilder().serializeNulls().create() }

    val creator = RetrofitCreator()

    single { creator.createService(get(), NetworkService::class.java) as NetworkService }

    single {
        Room.databaseBuilder(androidApplication(), ImagesDataBase::class.java, "images_data_base")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<ImagesDataBase>().imagesDao() }


    single<NetworkStorage> {
        NetworkStorageImpl(get())
    }

    single<DataBaseImagesStorage> { DataBaseImagesStorageImpl(get()) }


    single<NetworkRepository> {
        NetworkRepositoryImpl(get(), get(), get(), get(), get())
    }

    factory { ImagesToImagesDtoConverter() }

    factory { ImagesEntityToImagesDtoConverter() }

    factory { ImagesToImagesEntityConvertor() }
}
