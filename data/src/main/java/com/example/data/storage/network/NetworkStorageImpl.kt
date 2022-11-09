package com.example.data.storage.network

import com.example.data.BaseResponse
import com.example.data.storage.network.model.Images
import retrofit2.Response

class NetworkStorageImpl(private val networkService: NetworkService) : NetworkStorage {

    override suspend fun getImages(count: Int): Response<BaseResponse<ArrayList<Images>>> =
        networkService.getImages(
            quantity = count, locale = "en_US"
        )
}