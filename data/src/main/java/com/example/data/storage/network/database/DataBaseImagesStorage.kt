package com.example.data.storage.network.database

interface DataBaseImagesStorage {

    suspend fun getImages(): List<ImagesEntity>

    suspend fun insertImages(imagesEntity: ImagesEntity)
}
