package com.example.data.storage.network

import com.example.data.*
import com.example.data.storage.network.model.Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET(BOOK)
    suspend fun getBook(
        @Query(QUANTITY) quantity: Int,
        @Query(LOCALE) locale: String,
        ): Response<BaseResponse<ArrayList<Book>>>


}