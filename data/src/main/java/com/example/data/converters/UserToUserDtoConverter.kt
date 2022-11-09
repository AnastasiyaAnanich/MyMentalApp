package com.example.data.converters

import com.example.data.storage.network.model.Users
import com.example.domain.base.Convertor
import com.example.domain.models.UserDto

class UserToUserDtoConverter : Convertor<Users, UserDto> {
    override fun invoke(params: Users): UserDto {
        return UserDto(
            params.id ?: -1,
            params.uuid ?: "",
            params.firstname ?: "",
            params.lastname ?: "",
            params.username ?: "",
            params.password ?: "",
            params.email ?: "",
            params.ip ?:  "",
            params.macAddress ?: "",
            params.website ?: "",
            params.image ?: ""
        )
    }
}

