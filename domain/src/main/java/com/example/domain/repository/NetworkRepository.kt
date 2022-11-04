package com.example.domain.repository

import com.example.domain.models.BookDto

interface NetworkRepository {
    suspend fun getBooks(count: Int): List<BookDto>
}