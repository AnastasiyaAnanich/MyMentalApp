package com.example.data.repository

import com.example.data.converters.UserEntityToUserDtoConverter
import com.example.data.converters.UserToUserDtoConverter
import com.example.data.converters.UserToUserEntityConvertor
import com.example.data.storage.network.NetworkStorage
import com.example.data.storage.network.database.DataBaseUserStorage
import com.example.domain.models.UserDto
import com.example.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val networkStorage: NetworkStorage,
    private val dataBaseUserStorage: DataBaseUserStorage,
    private val userToUserDtoConverter: UserToUserDtoConverter,
    private val userToUserEntityConverter: UserToUserEntityConvertor,
    private val userEntityToUserDtoConverter: UserEntityToUserDtoConverter,

    ) : NetworkRepository {
    override suspend fun getUsers(count: Int): List<UserDto> {
        try {
            val response = networkStorage.getUsers(count)
            if (response.isSuccessful) {
                response.body()?.let { baseResponse ->
                    val user = mutableListOf<UserDto>()
                    baseResponse.data?.map { users ->
                        dataBaseUserStorage.insertUsers(userToUserEntityConverter.invoke(users))
                        user.add(userToUserDtoConverter.invoke(users))
                    }
                    return user
                }
            } else {
                val user = mutableListOf<UserDto>()
                dataBaseUserStorage.getUsers().map { userEntity ->
                    user.add(userEntityToUserDtoConverter.invoke(userEntity))
                }
                return user
            }
        } catch (e: Exception) {
            val user = mutableListOf<UserDto>()
            dataBaseUserStorage.getUsers().map { userEntity ->
                user.add(userEntityToUserDtoConverter.invoke(userEntity))
            }
            return user
        }
        return emptyList()
    }
}