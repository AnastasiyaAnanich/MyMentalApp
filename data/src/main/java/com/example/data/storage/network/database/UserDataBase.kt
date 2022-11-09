package com.example.data.storage.network.database


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
