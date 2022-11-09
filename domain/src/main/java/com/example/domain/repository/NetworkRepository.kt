package com.example.domain.repository

import com.example.domain.models.UserDto

interface NetworkRepository {

    suspend fun getUsers(count: Int): List<UserDto>
}
