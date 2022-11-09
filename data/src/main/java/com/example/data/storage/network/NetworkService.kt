package com.example.data.storage.network

import com.example.data.*
import com.example.data.storage.network.model.Images
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.ArrayList

interface NetworkService {

    @GET(IMAGES)
    suspend fun getImages(
        @Query(QUANTITY) quantity: Int,
        @Query(LOCALE) locale: String,
    ): Response<BaseResponse<ArrayList<Images>>>
}