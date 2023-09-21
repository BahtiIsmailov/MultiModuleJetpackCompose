package com.atom.ui.utils

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class EffectViewModel<UIState, UIEvent, UIEffect>(
    initialState: UIState,
) : BaseViewModel<UIState, UIEvent>(initialState) {

    private val effect = Channel<UIEffect>()

    val currentEffect: Flow<UIEffect>
        get() = effect.receiveAsFlow()

    fun sendEffect(currentEffect: UIEffect) {
        viewModelScope.launch {
            effect.send(currentEffect)
        }
    }
}
