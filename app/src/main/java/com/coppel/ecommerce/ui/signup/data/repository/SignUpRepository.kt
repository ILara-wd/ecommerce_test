package com.coppel.ecommerce.ui.signup.data.repository

import com.coppel.ecommerce.ui.signup.data.remote.SignUpRemoteDataSource
import com.coppel.ecommerce.ui.signup.data.remote.models.SignUpRequest
import com.coppel.ecommerce.ui.signup.data.remote.models.SignUpResponse
import javax.inject.Inject

class SignUpRepository @Inject constructor(
    private val signUpRemoteDataSource: SignUpRemoteDataSource
) {
    suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        return signUpRemoteDataSource.signUp(signUpRequest)
    }
}
