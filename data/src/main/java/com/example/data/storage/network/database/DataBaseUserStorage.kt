package com.example.data.storage.network.database

interface DataBaseUserStorage {

    suspend fun getUsers(): List<UserEntity>

    suspend fun insertUsers(userEntity: UserEntity)
}
