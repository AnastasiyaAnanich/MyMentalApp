package com.example.mentaldiary.fragment.diary

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mentaldiary.fragment.diary.Diary

@Dao
interface DiaryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg diary: Diary)

    @Update
     fun update(vararg diary: Diary)

    @Delete
     fun delete(vararg diary: Diary)

    @Query("SELECT * FROM diaryTable")
   fun getAllDiary(): LiveData<List<Diary>>

}