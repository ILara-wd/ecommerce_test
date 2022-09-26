package com.coppel.ecommerce.data.remote

import com.coppel.ecommerce.data.remote.services.CoppelApiServices
import com.coppel.ecommerce.data.signup.SignUpRequest
import com.coppel.ecommerce.data.signup.SignUpResponse
import javax.inject.Inject

class CoppelRemoteDataSource @Inject constructor(private val coppelApiServices: CoppelApiServices) {

    suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        return coppelApiServices.serviceCreateUser(signUpRequest)
    }

}
