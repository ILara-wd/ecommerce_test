package com.coppel.ecommerce.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.coppel.ecommerce.domain.usecases.IsEmailValid
import com.coppel.ecommerce.domain.usecases.IsPasswordValid
import com.coppel.ecommerce.ui.login.data.remote.models.LoginResponse
import com.coppel.ecommerce.ui.login.domain.usecases.LoginUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @RelaxedMockK
    private lateinit var loginUseCase: LoginUseCase

    @RelaxedMockK
    private lateinit var isEmailValid: IsEmailValid

    @RelaxedMockK
    private lateinit var isPasswordValid: IsPasswordValid

    private lateinit var viewModel: LoginViewModel

    @get:Rule
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        viewModel = LoginViewModel(loginUseCase, isEmailValid, isPasswordValid)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun wewe() = runTest {
        //Given
        coEvery { loginUseCase("werwer.w@qweer","123WF32") } returns LoginResponse("Credentials incorrect", 401)

        //When
        viewModel.doLogin()

        //Then
        assert(viewModel.state.value == LoginViewModel.State.ShowError("Credentials incorrect"))

    }

}
