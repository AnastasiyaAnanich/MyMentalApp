package com.example.domain.repository

import com.example.domain.models.ImagesDto

interface NetworkRepository {

    suspend fun getImages(count: Int): List<ImagesDto>
}
