package com.coppel.ecommerce.ui.login.domain.usecases

import com.coppel.ecommerce.ui.login.data.remote.models.LoginRequest
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import com.coppel.ecommerce.ui.login.data.repository.LoginRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LoginUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: LoginRepository

    lateinit var useCaseTest: LoginUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        useCaseTest = LoginUseCase(repository)
    }

    @Test
    fun verifyEndPoint() = runBlocking {
        //Given
        coEvery {
            repository.login(
                LoginRequest("irvinggLara@gmail.com", "123=?")
            )
        } returns LoginResponse("Credentials incorrect", 401)

        //When
        useCaseTest("irvinggLara@gmail.com", "123=?")

        //Then
        coVerify(exactly = 1) { repository.login(LoginRequest("irvinggLara@gmail.com", "123=?")) }

    }

}