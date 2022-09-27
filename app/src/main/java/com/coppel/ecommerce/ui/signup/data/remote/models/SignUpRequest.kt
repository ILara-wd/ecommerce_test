package com.coppel.ecommerce.ui.signup.data.remote.models

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("lastname")
    var lastname: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("password")
    var password: String? = null
)