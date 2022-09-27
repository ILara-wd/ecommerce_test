package com.coppel.ecommerce.ui.login.data.remote

import com.coppel.ecommerce.data.remote.services.CoppelApiServices
import com.coppel.ecommerce.data.signup.SignUpRequest
import com.coppel.ecommerce.data.signup.SignUpResponse
import com.coppel.ecommerce.ui.login.data.remote.models.LoginRequest
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import javax.inject.Inject

class LoginRemoteDataSource @Inject constructor(private val coppelApiServices: CoppelApiServices) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return coppelApiServices.serviceLogin(loginRequest)
    }
}
