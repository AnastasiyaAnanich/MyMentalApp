package com.example.data.storage.network.model

import com.google.gson.annotations.SerializedName

data class Images(

    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("url") val url: String? = null
)


