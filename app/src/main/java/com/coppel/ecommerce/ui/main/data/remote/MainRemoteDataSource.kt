package com.coppel.ecommerce.ui.main.data.remote

import com.coppel.ecommerce.data.remote.services.CoppelApiServices
import com.coppel.ecommerce.ui.main.data.remote.models.ReadProductResponse
import javax.inject.Inject

class MainRemoteDataSource @Inject constructor(private val coppelApiServices: CoppelApiServices) {

    suspend fun readProduct(): ReadProductResponse {
        return coppelApiServices.serviceReadProduct()
    }
}
