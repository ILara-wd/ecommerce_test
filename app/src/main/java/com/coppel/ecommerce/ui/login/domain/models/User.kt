package com.coppel.ecommerce.ui.login.domain.models

import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse

data class User(
    var id: String? = null,
    var name: String? = null,
    var lastname: String? = null,
    var email: String? = null
)

fun LoginResponse.toDomain() = User(
    id = user?.id,
    name = user?.name,
    lastname = user?.lastname,
    email = user?.email
)