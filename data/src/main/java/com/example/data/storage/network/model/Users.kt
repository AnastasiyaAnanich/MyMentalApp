package com.example.data.storage.network.model

import com.google.gson.annotations.SerializedName

data class Users(

    @SerializedName("id") val id: Int? = null,
    @SerializedName("uuid") val uuid: String? = null,
    @SerializedName("firstname") val firstname: String? = null,
    @SerializedName("lastname") val lastname: String? = null,
    @SerializedName("username") val username: String? = null,
    @SerializedName("password") val password: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("ip") val ip: String? = null,
    @SerializedName("macAddress") val macAddress: String? = null,
    @SerializedName("website") val website: String? = null,
    @SerializedName("image") val image: String? = null
)


