package com.example.data.storage.network.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImagesDao {
    @Query("SELECT * FROM images_entity_table")
    suspend fun getImagesAll(): List<ImagesEntity>

    @Insert(entity = ImagesEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImagesAll(vararg groupEntity: ImagesEntity)
}