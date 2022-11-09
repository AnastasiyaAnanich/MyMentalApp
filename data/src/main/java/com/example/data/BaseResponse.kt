package com.example.data

import com.google.gson.annotations.SerializedName

data class BaseResponse<DATA_TYPE>(
    @SerializedName("status") var status: String?,
    @SerializedName("code") var code: Int?,
    @SerializedName("total") var total: String?,
    @SerializedName("data") var data: DATA_TYPE?
)

