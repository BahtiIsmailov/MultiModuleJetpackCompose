package com.atom.ui.widgets.controller

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.atom.ui.widgets.R

data class ControllerState(
    val colorValue: Color,
    val title: String,
    val value: Int,
    val form: ControllerForm,
    val range: IntRange = -22..66
) {
    val textValue: String get() = value.toString()
    fun inRange(value: Int): Boolean = range.contains(value)

    val firstIconState: Pair<Int, Alignment>
        get() = when (form) {
            ControllerForm.VERTICAL -> Pair(R.drawable.up, Alignment.TopCenter)
            else -> Pair(R.drawable.left, Alignment.CenterStart)
        }

    val secondIconState: Pair<Int, Alignment>
        get() = when (form) {
            ControllerForm.HORIZONTAL -> Pair(R.drawable.right, Alignment.CenterEnd)
            ControllerForm.VERTICAL -> Pair(R.drawable.down, Alignment.BottomCenter)
            ControllerForm.ROUND -> Pair(R.drawable.up, Alignment.TopCenter)
        }
}

enum class ControllerForm {
    HORIZONTAL,
    VERTICAL,
    ROUND
}
