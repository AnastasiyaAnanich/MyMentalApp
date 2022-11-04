package com.example.mentaldiary.diary

import androidx.lifecycle.LiveData
import androidx.room.*

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