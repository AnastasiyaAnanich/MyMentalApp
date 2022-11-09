package com.example.data.storage.network

import com.example.data.BaseResponse
import com.example.data.storage.network.model.Images
import retrofit2.Response
import java.util.ArrayList

interface NetworkStorage {

     suspend fun getImages(count: Int): Response<BaseResponse<ArrayList<Images>>>
}