package com.atom.ui.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<UIState, UIEvent>(
    initialState: UIState,
) : ViewModel(), Stateful<UIState, UIEvent> {

    private val mutableStateFlow = MutableStateFlow(initialState)

    open val handler = CoroutineExceptionHandler { context, exception ->
        exceptionHandler(context, exception)
    }

    protected open fun exceptionHandler(context: CoroutineContext, exception: Throwable) {
        Timber.i("Caught $exception in $context")
    }

    override val state: UIState
        get() = stateFlow.value

    override val stateFlow: StateFlow<UIState>
        get() = mutableStateFlow.asStateFlow()

    override fun updateState(transform: (UIState) -> UIState) {
        mutableStateFlow.update { state ->
            transform(state)
        }
    }

    protected inline fun launch(
        crossinline action: suspend () -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher + handler + SupervisorJob()) {
            action.invoke()
        }

    }

    protected fun repeat(
        repeatMillis: Long,
        action: suspend () -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher + handler + SupervisorJob()) {
            while (isActive) {
                action()
                delay(repeatMillis)
            }
        }
    }
    abstract fun renderState(event: UIEvent)
}

interface Stateful<UIState, UIEvent> {
    val state: UIState
    val stateFlow: StateFlow<UIState>
    fun updateState(transform: (UIState) -> UIState)
}
