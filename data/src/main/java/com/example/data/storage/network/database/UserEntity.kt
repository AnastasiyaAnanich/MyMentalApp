package com.example.data.storage.network.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.storage.network.database.UserEntity.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class UserEntity(
    @PrimaryKey val id: Int? = null,
    @ColumnInfo(name = "uuid") val uuid: String? = null,
    @ColumnInfo(name = "firstname") val firstname: String? = null,
    @ColumnInfo(name = "lastname") val lastname: String? = null,
    @ColumnInfo(name = "username") val username: String? = null,
    @ColumnInfo(name = "password") val password: String? = null,
    @ColumnInfo(name = "email") val email: String? = null,
    @ColumnInfo(name = "ip") val ip: String? = null,
    @ColumnInfo(name = "macAddress") val macAddress: String? = null,
    @ColumnInfo(name = "website") val website: String? = null,
    @ColumnInfo(name = "image") val image: String? = null
) {
    companion object {
        const val TABLE_NAME = "user_entity_table"
    }
}
