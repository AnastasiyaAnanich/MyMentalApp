package com.example.data.storage.network

import com.example.data.BaseResponse
import com.example.data.storage.network.model.Book
import retrofit2.Response

interface NetworkStorage {
     suspend fun getBooks(count:Int): Response<BaseResponse<ArrayList<Book>>>
}