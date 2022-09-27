package com.coppel.ecommerce.ui.login.data.repository

import com.coppel.ecommerce.ui.login.data.remote.LoginRemoteDataSource
import com.coppel.ecommerce.ui.login.data.remote.models.LoginRequest
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource
) {
    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return loginRemoteDataSource.login(loginRequest)
    }
}
