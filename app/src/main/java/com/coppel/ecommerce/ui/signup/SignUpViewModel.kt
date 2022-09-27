package com.coppel.ecommerce.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coppel.ecommerce.domain.usecases.IsEmailValid
import com.coppel.ecommerce.domain.usecases.IsPasswordValid
import com.coppel.ecommerce.ui.signup.domain.usecases.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val isEmailValid: IsEmailValid,
    private val isPasswordValid: IsPasswordValid,
) : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.IncompleteRequirements)
    val state: StateFlow<State> get() = _state

    private val _isSignUpButtonEnabled: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isSignUpButtonEnabled: StateFlow<Boolean> get() = _isSignUpButtonEnabled

    fun validateRegister() = viewModelScope.launch {
        _isSignUpButtonEnabled.value =
            isEmailValid(email) && isPasswordValid(password) && lastname.isNotEmpty() && name.isNotEmpty()
    }

    var name: String = ""
    var lastname: String = ""
    var email: String = ""
    var password: String = ""

    fun doRegister() {
        _state.value = State.Loading
        viewModelScope.launch {
            kotlin.runCatching {
                signUpUseCase(
                    name = name,
                    lastname = lastname,
                    email = email,
                    password = password
                )
            }
                .onSuccess { response ->
                    if (response.code == 200) {
                        _state.value = State.Success(response.message ?: "")
                    } else {
                        _state.value = State.ShowError(response.message ?: "")
                    }
                }
                .onFailure {
                    _state.value = State.ShowError(it.message ?: "")
                }
        }
    }

    sealed class State {
        object Loading : State()
        data class Success(val response: String) : State()
        object IncompleteRequirements : State()
        data class ShowError(val message: String) : State()
    }

}