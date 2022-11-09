package com.example.data.storage.network

import com.example.data.*
import com.example.data.storage.network.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.ArrayList

interface NetworkService {

    @GET(USERS)
    suspend fun getUsers(
        @Query(QUANTITY) quantity: Int,
        @Query(GENDER) gender: String,
    ): Response<BaseResponse<ArrayList<Users>>>
}