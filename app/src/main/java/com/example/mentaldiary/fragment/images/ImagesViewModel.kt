package com.example.mentaldiary.fragment.images

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ImagesDto
import com.example.domain.usecase.GetImagesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImagesViewModel(private val usersUseCase: GetImagesUseCase) : ViewModel() {

    private val _userLiveData = MutableLiveData<List<ImagesDto>>()
    val userLiveData: LiveData<List<ImagesDto>> = _userLiveData

    fun getImages(count: Int) {
        viewModelScope.launch {
            val result: List<ImagesDto>
            withContext(Dispatchers.IO) {
                result = usersUseCase.execute(count)
            }
            _userLiveData.value = result
        }
    }
}