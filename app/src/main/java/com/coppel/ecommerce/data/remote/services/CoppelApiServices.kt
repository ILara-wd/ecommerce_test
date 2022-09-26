package com.coppel.ecommerce.data.remote.services

import com.coppel.ecommerce.data.remote.services.CoppelServiceNames.CREATE_USER
import com.coppel.ecommerce.data.signup.SignUpRequest
import com.coppel.ecommerce.data.signup.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface CoppelApiServices {

    @GET(CREATE_USER)
    suspend fun serviceCreateUser(@Body signUpRequest: SignUpRequest): SignUpResponse

}
