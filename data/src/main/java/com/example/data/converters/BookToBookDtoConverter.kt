package com.example.data.converters

import com.example.data.storage.network.model.Book
import com.example.domain.models.BookDto
import retrofit2.Converter

class BookToBookDtoConverter : Converter<Book, BookDto> {
    override fun convert(params: Book): BookDto {
        return BookDto(
            params.id ?: -1,
            params.tittle ?: "",
            params.author ?: "",
            params.genre ?: "",
            params.description?:"",
            params.isbn?:"",
            params.image?:"",
            params.published?:"",
            params.publisher?:""

            )
    }
}