package com.example.data.storage.network

import com.example.data.BaseResponse
import com.example.data.storage.network.model.Book
import retrofit2.Response

class NetworkStorageImpl(private val networkService: NetworkService) : NetworkStorage {
    override suspend fun getBooks(count: Int): Response<BaseResponse<ArrayList<Book>>> =
        networkService.getBook(
            quantity = count,
            locale = "en_US"
        )


}