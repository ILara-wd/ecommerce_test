package com.coppel.ecommerce.data.remote

import com.coppel.ecommerce.data.remote.services.CoppelApiServices
import com.coppel.ecommerce.data.signup.SignUpRequest
import com.coppel.ecommerce.data.signup.SignUpResponse
import com.coppel.ecommerce.ui.login.data.remote.models.LoginRequest
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import javax.inject.Inject

class CoppelRemoteDataSource @Inject constructor(private val coppelApiServices: CoppelApiServices) {

    suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        return coppelApiServices.serviceRegisterUser(signUpRequest)
    }

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return coppelApiServices.serviceLogin(loginRequest)
    }
}
