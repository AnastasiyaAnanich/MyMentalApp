package com.example.data.repository

import com.example.data.storage.network.NetworkStorage
import com.example.domain.models.BookDto
import com.example.domain.repository.NetworkRepository

class NetworkRepositoryImpl(private val networkStorage: NetworkStorage) : NetworkRepository {
    override suspend fun getBooks(count: Int): List<BookDto> {
        try {
            val response = networkStorage.getBooks(count)
            if (response.isSuccessful) {
                response.body()?.let { baseResponse ->
                    val book = mutableListOf<BookDto>()
                    baseResponse.data?.map { book ->
                        book.add(
                            BookDto(
                                book.id ?: -1,
                                book.tittle ?: "",
                                book.author ?: "",
                                book.genre ?: "",
                                book.description ?: "",
                                book.isbn ?: "",
                                book.image ?: "",
                                book.published ?: "",
                                book.publisher ?: "",
                                )
                        )
                    }
                    return book

                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return emptyList()
    }
}