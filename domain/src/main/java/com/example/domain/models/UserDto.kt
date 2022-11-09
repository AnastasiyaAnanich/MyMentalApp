package com.example.domain.models

data class UserDto(
    val id: Int,
    val uuid: String,
    val firstname: String,
    val lastname: String,
    val username: String,
    val password: String,
    val email: String,
    val ip: String,
    val macAddress: String,
    val website: String,
    val image: String
)