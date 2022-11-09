package com.example.data.storage.network.database


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ImagesEntity::class], version = 1, exportSchema = true)
abstract class ImagesDataBase : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao
}
