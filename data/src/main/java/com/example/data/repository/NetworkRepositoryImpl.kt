package com.example.data.repository

import com.example.data.converters.BookToBookDtoConverter
import com.example.data.storage.network.NetworkStorage
import com.example.domain.models.BookDto
import com.example.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val networkStorage: NetworkStorage,
    private val bookToBookDtoConverter: BookToBookDtoConverter
) : NetworkRepository {
    override suspend fun getBooks(count: Int): List<BookDto> {
        try {
            val response = networkStorage.getBooks(count)
            if (response.isSuccessful) {
                response.body()?.let { baseResponse ->
                    val book = mutableListOf<BookDto>()
                    baseResponse.data?.map { book ->
                        book.add(
                            bookToBookDtoConverter.convert(book)
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