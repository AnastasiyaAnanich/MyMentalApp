package com.example.mentaldiary.diary

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mentaldiary.diary.Diary

@Dao
interface DiaryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(diary: Diary)

    @Update
    suspend fun update(diary: Diary)

    @Delete
    suspend fun delete(diary: Diary)

    @Query("Select * from diaryTable order by id ASC")
    fun getAllDiary(): LiveData<List<Diary>>

}