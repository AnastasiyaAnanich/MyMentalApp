package com.example.data.converters

import com.example.data.storage.network.database.UserEntity
import com.example.domain.base.Convertor
import com.example.domain.models.UserDto

class UserEntityToUserDtoConverter : Convertor<UserEntity, UserDto> {
    override fun invoke(params: UserEntity): UserDto {
        return UserDto(
            id = params.id ?: -1,
            uuid = params.uuid ?: "",
            firstname = params.firstname ?: "",
            lastname = params.lastname ?: "",
            username = params.username ?: "",
            password = params.password ?: "",
            email = params.email ?: "",
            ip = params.ip ?: "",
            macAddress = params.macAddress ?: "",
            website = params.website ?: "",
            image = params.image ?: ""
        )
    }
}