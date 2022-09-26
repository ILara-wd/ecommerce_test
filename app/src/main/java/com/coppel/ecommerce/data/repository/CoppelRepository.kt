package com.coppel.ecommerce.data.repository

import com.coppel.ecommerce.data.remote.CoppelRemoteDataSource
import com.coppel.ecommerce.data.signup.SignUpRequest
import com.coppel.ecommerce.data.signup.SignUpResponse
import javax.inject.Inject

class CoppelRepository @Inject constructor(
    private val coppelRemoteDataSource: CoppelRemoteDataSource
) {
    suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        return coppelRemoteDataSource.signUp(signUpRequest)
    }
}
