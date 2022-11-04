package com.example.data.storage.network.model

import com.example.domain.models.BookDto
import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("tittle") val tittle: String? = null,
    @SerializedName("author") val author: String? = null,
    @SerializedName("genre") val genre: String? = null,
    @SerializedName("desription") val description: String? = null,
    @SerializedName("isbn") val isbn: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("published") val published: String? = null,
    @SerializedName("publisher") val publisher: String? = null

) {
    fun add(bookDto: BookDto) {

    }
}
