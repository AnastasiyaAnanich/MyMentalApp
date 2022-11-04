package com.example.mentaldiary.diary

import androidx.lifecycle.LiveData
import com.example.mentaldiary.diary.Diary
import com.example.mentaldiary.diary.DiaryDao

class DiaryRepository(private val diaryDao: DiaryDao) {
    val allDiary: LiveData<List<Diary>> = diaryDao.getAllDiary()

    suspend fun insert(diary: Diary) {
        diaryDao.insert(diary)
    }

    suspend fun delete(diary: Diary) {
        diaryDao.delete(diary)
    }

    suspend fun update(diary: Diary) {
        diaryDao.update(diary)
    }

}