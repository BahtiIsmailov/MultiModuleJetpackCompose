package com.atom.ui.utils.effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
inline fun AtomStartEffect(
    delay: Long,
    crossinline onStartEvent: () -> Unit)
{
    LaunchedEffect(Unit) {
        delay(delay)
        onStartEvent.invoke()
    }
}
