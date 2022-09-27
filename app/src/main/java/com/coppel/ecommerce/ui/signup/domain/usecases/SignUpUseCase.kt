package com.coppel.ecommerce.ui.signup.domain.usecases

import com.coppel.ecommerce.domain.dispatchers.DispatcherProvider
import com.coppel.ecommerce.ui.signup.data.repository.SignUpRepository
import com.coppel.ecommerce.ui.signup.data.remote.models.SignUpRequest
import com.coppel.ecommerce.ui.signup.data.remote.models.SignUpResponse
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend operator fun invoke(
        name: String, lastname: String,
        email: String, password: String
    ): SignUpResponse = withContext(dispatcherProvider.default) {
        signUpRepository.signUp(
            SignUpRequest(
                name = name,
                lastname = lastname,
                email = email,
                password = password
            )
        )
    }
}
