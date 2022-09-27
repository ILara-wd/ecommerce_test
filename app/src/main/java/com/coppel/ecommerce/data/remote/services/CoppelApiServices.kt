package com.coppel.ecommerce.data.remote.services

import com.coppel.ecommerce.data.remote.services.CoppelServiceNames.REGISTER
import com.coppel.ecommerce.data.remote.services.CoppelServiceNames.LOGIN
import com.coppel.ecommerce.data.signup.SignUpRequest
import com.coppel.ecommerce.data.signup.SignUpResponse
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import com.coppel.ecommerce.ui.login.data.remote.models.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface CoppelApiServices {

    @POST(REGISTER)
    suspend fun serviceRegisterUser(@Body signUpRequest: SignUpRequest): SignUpResponse

    @POST(LOGIN)
    suspend fun serviceLogin(@Body loginRequest: LoginRequest): LoginResponse

}
