package com.coppel.ecommerce.ui.main.domain.usecases

import com.coppel.ecommerce.domain.dispatchers.DispatcherProvider
import com.coppel.ecommerce.ui.main.data.remote.models.ReadProductResponse
import com.coppel.ecommerce.ui.main.data.repository.MainRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend operator fun invoke(): ReadProductResponse = withContext(dispatcherProvider.default) {
        mainRepository.readProduct()
    }
}
