package com.coppel.ecommerce.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coppel.ecommerce.ui.main.data.remote.models.ProductResponse
import com.coppel.ecommerce.ui.main.domain.usecases.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<State> =
        MutableStateFlow(State.IncompleteRequirements)
    val state: StateFlow<State> get() = _state

    fun doReadProduct() {
        _state.value = State.Loading
        viewModelScope.launch {
            kotlin.runCatching {
                mainUseCase()
            }
                .onSuccess { response ->
                    if (response.product.isNotEmpty()) {
                        _state.value = State.Success
                        _state.value = State.ShowResults(response.product)
                    } else {
                        _state.value = State.ShowError("Empty")
                    }
                }
                .onFailure {
                    _state.value = State.ShowError(it.message ?: "")
                }
        }
    }

    sealed class State {
        object Loading : State()
        object Success : State()
        object IncompleteRequirements : State()
        data class ShowError(val message: String) : State()
        data class ShowResults(val response: List<ProductResponse>) : State()
    }

}