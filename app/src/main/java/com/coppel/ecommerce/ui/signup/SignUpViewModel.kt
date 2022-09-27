package com.coppel.ecommerce.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coppel.ecommerce.ui.login.domain.usecases.IsEmailValid
import com.coppel.ecommerce.ui.login.domain.usecases.IsPasswordValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val isEmailValid: IsEmailValid,
    private val isPasswordValid: IsPasswordValid,
) : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.IncompleteRequirements)
    val state: StateFlow<State> get() = _state

    private val _isSignUpButtonEnabled: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isSignUpButtonEnabled: StateFlow<Boolean> get() = _isSignUpButtonEnabled

    fun validateCredentials() = viewModelScope.launch {
        _isSignUpButtonEnabled.value =
            isEmailValid(email) && isPasswordValid(password) && lastname.isNotEmpty() && name.isNotEmpty()
    }

    var email: String = ""
    var password: String = ""
    var name: String = ""
    var lastname: String = ""

    fun doRegister() {}

    sealed class State {
        object Loading : State()
        data class Success(val response: String) : State()
        object IncompleteRequirements : State()
        data class ShowError(val message: String) : State()
    }

}