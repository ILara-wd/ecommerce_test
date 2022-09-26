package com.coppel.ecommerce.data.signup

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("email")
    var email: String? = null
)


data class UserDao(
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null
)

fun SignUpResponse.toDomain() = UserDao(
    id = id,
    name = name,
    email = email
)