package com.example.data.converters

import com.example.data.storage.network.database.ImagesEntity
import com.example.domain.base.Convertor
import com.example.domain.models.ImagesDto

class ImagesEntityToImagesDtoConverter : Convertor<ImagesEntity, ImagesDto> {
    override fun invoke(params: ImagesEntity): ImagesDto {
        return ImagesDto(
            title = params.title ?: "",
            description = params.description ?: "",
            url = params.url ?: ""

        )
    }
}


