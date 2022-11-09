package com.example.data.converters

import com.example.data.storage.network.model.Images
import com.example.domain.base.Convertor
import com.example.domain.models.ImagesDto

class ImagesToImagesDtoConverter : Convertor<Images, ImagesDto> {
    override fun invoke(params: Images): ImagesDto {
        return ImagesDto(
            params.title ?: "",
            params.description ?: "",
            params.url ?: ""

        )
    }
}

