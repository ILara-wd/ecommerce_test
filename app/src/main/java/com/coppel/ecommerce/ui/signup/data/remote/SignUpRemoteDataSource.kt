package com.coppel.ecommerce.ui.signup.data.remote

import com.coppel.ecommerce.data.remote.services.CoppelApiServices
import com.coppel.ecommerce.ui.signup.data.remote.models.SignUpRequest
import com.coppel.ecommerce.ui.signup.data.remote.models.SignUpResponse
import javax.inject.Inject

class SignUpRemoteDataSource @Inject constructor(private val coppelApiServices: CoppelApiServices) {

    suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        return coppelApiServices.serviceRegisterUser(signUpRequest)
    }
}
