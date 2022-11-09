package com.example.data.storage.network

import com.example.data.BaseResponse
import com.example.data.storage.network.model.Users
import retrofit2.Response
import java.util.ArrayList

class NetworkStorageImpl(private val networkService: NetworkService) : NetworkStorage {

    override suspend fun getUsers(count: Int): Response<BaseResponse<ArrayList<Users>>> =
        networkService.getUsers(
            quantity = count, gender = "male"
        )
}