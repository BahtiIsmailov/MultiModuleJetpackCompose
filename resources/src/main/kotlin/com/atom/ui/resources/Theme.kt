package com.atom.ui.resources

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Colors
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AtomTheme(
    colors: Colors = AtomTheme.colors,
    dimens: Dimens = AtomTheme.dimens,
    typography: androidx.compose.material.Typography = AtomTheme.typography,
    content: @Composable () -> Unit
) {
    val rippleIndication = rememberRipple(color = colors.primary)

    val selectionColors = TextSelectionColors(
        handleColor = AtomTheme.colors.onPrimary,
        backgroundColor = AtomTheme.colors.primary.copy(alpha = DefaultSelectionBackgroundAlpha)
    )

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalDimens provides dimens,
        LocalTypography provides typography,
        LocalIndication provides rippleIndication,
        LocalTextSelectionColors provides selectionColors,
        LocalContentAlpha provides ContentAlpha.high,
    ) {
        ProvideTextStyle(value = typography.body1, content = content)
    }
}

object AtomTheme {

    val colors: Colors
        @Composable
        get() = LocalColors.current

    val typography: androidx.compose.material.Typography
        @Composable
        get() = LocalTypography.current

    val dimens: Dimens
        @Composable
        get() = LocalDimens.current
}

private const val DefaultSelectionBackgroundAlpha = 0.4f
