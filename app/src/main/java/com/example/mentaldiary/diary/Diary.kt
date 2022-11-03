package com.example.mentaldiary.diary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diaryTable")
class Diary(
    @ColumnInfo(name = "tittle") val diaryTittle: String,
    @ColumnInfo(name = "description") val diaryDescription: String,
    @ColumnInfo(name = "timeStamp") val diaryTimeStamp: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}