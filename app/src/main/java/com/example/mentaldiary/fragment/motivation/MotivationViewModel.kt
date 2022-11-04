package com.example.mentaldiary.fragment.motivation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.BookDto
import com.example.domain.usecase.GetBookUseCase
import kotlinx.coroutines.launch

class MotivationViewModel(private val bookUseCase: GetBookUseCase) : ViewModel() {

    private val _bookLiveData = MutableLiveData<List<BookDto>>()
    val bookLiveData: LiveData<List<BookDto>> = _bookLiveData

    fun getBook(count: Int) {
        viewModelScope.launch {
            _bookLiveData.value = bookUseCase.execute(count)
        }

    }

}