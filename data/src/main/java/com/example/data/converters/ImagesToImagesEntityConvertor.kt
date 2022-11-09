package com.example.data.converters

import com.example.data.storage.network.database.ImagesEntity
import com.example.data.storage.network.model.Images
import com.example.domain.base.Convertor

class ImagesToImagesEntityConvertor : Convertor<Images, ImagesEntity> {
    override fun invoke(params: Images): ImagesEntity {
        return ImagesEntity(
            title = params.title,
            description = params.description,
            url = params.url
        )
    }
}

