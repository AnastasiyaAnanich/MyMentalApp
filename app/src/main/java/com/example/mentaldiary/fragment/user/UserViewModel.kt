package com.example.mentaldiary.fragment.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UserDto
import com.example.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val usersUseCase: GetUsersUseCase) : ViewModel() {

    private val _userLiveData = MutableLiveData<List<UserDto>>()
    val userLiveData: LiveData<List<UserDto>> = _userLiveData

    fun getUsers(count: Int) {
        viewModelScope.launch {
            val result: List<UserDto>
            withContext(Dispatchers.IO) {
                result = usersUseCase.execute(count)
            }
            _userLiveData.value = result
        }
    }
}