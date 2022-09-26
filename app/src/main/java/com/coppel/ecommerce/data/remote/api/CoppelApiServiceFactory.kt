package com.coppel.ecommerce.data.remote.api

import com.coppel.ecommerce.data.di.CoppelRetrofit
import com.coppel.ecommerce.domain.remote.ServiceFactory
import retrofit2.Retrofit
import javax.inject.Inject

internal class CoppelApiServiceFactory @Inject constructor(
    @CoppelRetrofit private val retrofit: Retrofit,
) : ServiceFactory {

    override fun <T> createApiService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}
