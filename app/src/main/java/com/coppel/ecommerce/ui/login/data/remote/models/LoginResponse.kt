package com.coppel.ecommerce.ui.login.data.remote.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    var message: String? = null,
    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("user")
    var user: UserResponse? = null
)

data class UserResponse(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("lastname")
    var lastname: String? = null,
    @SerializedName("email")
    var email: String? = null
)