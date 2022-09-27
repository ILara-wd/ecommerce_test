package com.coppel.ecommerce.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coppel.ecommerce.ui.login.domain.models.User
import com.coppel.ecommerce.ui.login.domain.models.toDomain
import com.coppel.ecommerce.ui.login.domain.usecases.IsEmailValid
import com.coppel.ecommerce.ui.login.domain.usecases.IsPasswordValid
import com.coppel.ecommerce.ui.login.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val isEmailValid: IsEmailValid,
    private val isPasswordValid: IsPasswordValid,
) : ViewModel() {

    private var charactersDBS: User? = null
    private val _state: MutableStateFlow<State> = MutableStateFlow(State.IncompleteRequirements)
    val state: StateFlow<State> get() = _state

    private val _isSignInButtonEnabled: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isSignInButtonEnabled: StateFlow<Boolean> get() = _isSignInButtonEnabled

    fun validateCredentials() = viewModelScope.launch {
        _isSignInButtonEnabled.value = isEmailValid(email) && isPasswordValid(password)
    }

    var email: String = ""
    var password: String = ""

    fun doLogin() {
        _state.value = State.Loading
        viewModelScope.launch {
            kotlin.runCatching {
                loginUseCase(email, password)
            }
                .onSuccess { response ->
                    if (response.code == 200) {
                        charactersDBS = response.toDomain()
                        _state.value = State.Success
                        _state.value = State.ShowResults(charactersDBS)
                    } else {
                        _state.value = State.ShowError
                    }
                }
                .onFailure {
                    _state.value = State.ShowError
                }
        }
    }

    sealed class State {
        object Loading : State()
        object Success : State()
        object IncompleteRequirements : State()
        object ShowError : State()
        data class ShowResults(val response: User?) : State()
    }

}
