package com.example.data.storage.network.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user_entity_table")
    suspend fun getAllUsers(): List<UserEntity>

    @Insert(entity = UserEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUsers(vararg groupEntity: UserEntity)
}