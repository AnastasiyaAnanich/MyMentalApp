package com.example.data.repository

import com.example.data.converters.ImagesEntityToImagesDtoConverter
import com.example.data.converters.ImagesToImagesDtoConverter
import com.example.data.converters.ImagesToImagesEntityConvertor
import com.example.data.storage.network.NetworkStorage
import com.example.data.storage.network.database.DataBaseImagesStorage
import com.example.domain.models.ImagesDto
import com.example.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val networkStorage: NetworkStorage,
    private val dataBaseUserStorage: DataBaseImagesStorage,
    private val userToUserDtoConverter: ImagesToImagesDtoConverter,
    private val userToUserEntityConverter: ImagesToImagesEntityConvertor,
    private val imagesEntityToImagesDtoConverter: ImagesEntityToImagesDtoConverter,

    ) : NetworkRepository {
    override suspend fun getImages(count: Int): List<ImagesDto> {
        try {
            val response = networkStorage.getImages(count)
            if (response.isSuccessful) {
                response.body()?.let { baseResponse ->
                    val user = mutableListOf<ImagesDto>()
                    baseResponse.data?.map { users ->
                        dataBaseUserStorage.insertImages(userToUserEntityConverter.invoke(users))
                        user.add(userToUserDtoConverter.invoke(users))
                    }
                    return user
                }
            } else {
                val user = mutableListOf<ImagesDto>()
                dataBaseUserStorage.getImages().map { userEntity ->
                    user.add(imagesEntityToImagesDtoConverter.invoke(userEntity))
                }
                return user
            }
        } catch (e: Exception) {
            val user = mutableListOf<ImagesDto>()
            dataBaseUserStorage.getImages().map { userEntity ->
                user.add(imagesEntityToImagesDtoConverter.invoke(userEntity))
            }
            return user
        }
        return emptyList()
    }
}