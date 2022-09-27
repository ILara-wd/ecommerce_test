package com.coppel.ecommerce.ui.login.domain.usecases

import com.coppel.ecommerce.domain.dispatchers.DispatcherProvider
import com.coppel.ecommerce.ui.login.data.remote.models.LoginRequest
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import com.coppel.ecommerce.ui.login.data.repository.LoginRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend operator fun invoke(
        email: String, password: String
    ): LoginResponse = withContext(dispatcherProvider.default) {
        loginRepository.login(LoginRequest(email, password))
    }
}
