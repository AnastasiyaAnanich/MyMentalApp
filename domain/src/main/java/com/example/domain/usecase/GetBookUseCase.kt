package com.example.domain.usecase

import com.example.domain.base.SuspendUseCase
import com.example.domain.models.BookDto
import com.example.domain.repository.NetworkRepository

class GetBookUseCase(private val networkRepository: NetworkRepository) :
    SuspendUseCase<Int, List<BookDto>> {
    override suspend fun execute(params: Int?): List<BookDto> {
        return networkRepository.getBooks(params!!)
    }
}