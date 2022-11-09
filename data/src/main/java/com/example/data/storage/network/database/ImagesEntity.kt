package com.example.data.storage.network.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.storage.network.database.ImagesEntity.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class ImagesEntity(
    @PrimaryKey val id: Int? = null,
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @ColumnInfo(name = "url") val url: String? = null,

    ) {
    companion object {
        const val TABLE_NAME = "images_entity_table"
    }
}
