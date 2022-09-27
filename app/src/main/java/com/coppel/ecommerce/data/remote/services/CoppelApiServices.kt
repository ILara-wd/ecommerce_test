package com.coppel.ecommerce.data.remote.services

import com.coppel.ecommerce.data.remote.services.CoppelServiceNames.REGISTER
import com.coppel.ecommerce.data.remote.services.CoppelServiceNames.LOGIN
import com.coppel.ecommerce.data.remote.services.CoppelServiceNames.READ_PRODUCT
import com.coppel.ecommerce.ui.signup.data.remote.models.SignUpRequest
import com.coppel.ecommerce.ui.signup.data.remote.models.SignUpResponse
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import com.coppel.ecommerce.ui.login.data.remote.models.LoginRequest
import com.coppel.ecommerce.ui.main.data.remote.models.ReadProductResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CoppelApiServices {

    @POST(REGISTER)
    suspend fun serviceRegisterUser(@Body signUpRequest: SignUpRequest): SignUpResponse

    @POST(LOGIN)
    suspend fun serviceLogin(@Body loginRequest: LoginRequest): LoginResponse

    @GET(READ_PRODUCT)
    suspend fun serviceReadProduct(): ReadProductResponse

}
