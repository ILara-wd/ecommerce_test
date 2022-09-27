package com.coppel.ecommerce.ui.main.data.repository

import com.coppel.ecommerce.ui.main.data.remote.models.ReadProductResponse
import com.coppel.ecommerce.ui.main.data.remote.MainRemoteDataSource
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val mainRemoteDataSource: MainRemoteDataSource
) {
    suspend fun readProduct(): ReadProductResponse {
        return mainRemoteDataSource.readProduct()
    }
}
