package com.coppel.ecommerce.ui.signup.data.remote.models

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("message")
    var message: String? = null,
    @SerializedName("code")
    var code: Int? = null
)