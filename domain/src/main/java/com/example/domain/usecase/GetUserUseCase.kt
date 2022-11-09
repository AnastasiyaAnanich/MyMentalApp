package com.example.domain.usecase

import com.example.domain.base.SuspendUseCase
import com.example.domain.models.UserDto
import com.example.domain.repository.NetworkRepository

class GetUsersUseCase(private val networkRepository: NetworkRepository) :
    SuspendUseCase<Int, List<UserDto>> {
    override suspend fun execute(param: Int?): List<UserDto> {
        return networkRepository.getUsers(param!!)
    }
}