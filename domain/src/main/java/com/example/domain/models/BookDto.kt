package com.example.domain.models

data class BookDto(
    val id: Int,
    val tittle: String,
    val author: String,
    val genre: String,
    val description: String,
    val isbn: String,
    val image: String,
    val published: String,
    val publisher: String

)