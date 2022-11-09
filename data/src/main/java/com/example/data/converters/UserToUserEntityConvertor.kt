package com.example.data.converters

import com.example.data.storage.network.database.UserEntity
import com.example.data.storage.network.model.Users
import com.example.domain.base.Convertor

class UserToUserEntityConvertor : Convertor<Users, UserEntity> {
    override fun invoke(params: Users): UserEntity {
        return UserEntity(
            id = params.id,
            uuid = params.uuid,
            firstname = params.firstname,
            lastname = params.lastname,
            username = params.username,
            password = params.password,
            email = params.email,
            ip = params.ip,
            macAddress = params.macAddress,
            website = params.website,
            image = params.image
        )
    }
}

