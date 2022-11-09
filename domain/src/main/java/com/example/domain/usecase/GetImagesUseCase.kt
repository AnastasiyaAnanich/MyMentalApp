package com.example.domain.usecase

import com.example.domain.base.SuspendUseCase
import com.example.domain.models.ImagesDto
import com.example.domain.repository.NetworkRepository

class GetImagesUseCase(private val networkRepository: NetworkRepository) :
    SuspendUseCase<Int, List<ImagesDto>> {
    override suspend fun execute(param: Int?): List<ImagesDto> {
        return networkRepository.getImages(param!!)
    }
}