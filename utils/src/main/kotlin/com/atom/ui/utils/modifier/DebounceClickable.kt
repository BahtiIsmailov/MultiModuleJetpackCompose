package com.atom.ui.utils.modifier

import android.annotation.SuppressLint
import android.os.SystemClock
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.debounceClickable(
    debounceInterval: Long = 400L,
    onClick: () -> Unit,
): Modifier {
    return composed {
        var lastClickTime by remember { mutableLongStateOf(0L) }
        clickable {
            val currentTime = SystemClock.elapsedRealtime()
            if (currentTime - lastClickTime < debounceInterval) return@clickable
            lastClickTime = currentTime
            onClick()
        }
    }
}
