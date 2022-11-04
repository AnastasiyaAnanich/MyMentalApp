package com.example.mentaldiary.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mentaldiary.diary.Diary
import com.example.mentaldiary.diary.DiaryDatabase
import com.example.mentaldiary.diary.DiaryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DiaryViewModel(application: Application) : AndroidViewModel(application) {
    private val allDiary: LiveData<List<Diary>>
    private val repository: DiaryRepository

    init {
        val dao = DiaryDatabase.getDatabase(application).getDiaryDao()
        repository = DiaryRepository(dao)
        allDiary = repository.allDiary
    }

    fun deleteDiary(diary: Diary) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(diary)
    }

    fun updateDiary(diary: Diary) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(diary)
    }

    fun addDiary(diary: Diary) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(diary)
    }
}