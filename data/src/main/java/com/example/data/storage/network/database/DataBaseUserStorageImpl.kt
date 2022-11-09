package com.example.data.storage.network.database

class DataBaseUserStorageImpl(
    private val userDao: UserDao
) : DataBaseUserStorage {
    override suspend fun getUsers(): List<UserEntity> = userDao.getAllUsers()

    override suspend fun insertUsers(userEntity: UserEntity) = userDao.insertAllUsers()
}
