package com.example.data.storage.network.database

class DataBaseImagesStorageImpl(
    private val imagesDao: ImagesDao
) : DataBaseImagesStorage {
    override suspend fun getImages(): List<ImagesEntity> = imagesDao.getImagesAll()

    override suspend fun insertImages(imagesEntity: ImagesEntity) = imagesDao.insertImagesAll()
}
