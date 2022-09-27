package com.coppel.ecommerce.ui.login.data.repository

import com.coppel.ecommerce.data.remote.CoppelRemoteDataSource
import com.coppel.ecommerce.ui.login.data.remote.models.LoginRequest
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val coppelRemoteDataSource: CoppelRemoteDataSource
) {
    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return coppelRemoteDataSource.login(loginRequest)
    }
}
