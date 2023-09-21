package com.atom.ui.resources

import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val DarkBlueColor = Color(0xFF003366)
val LakeBlueColor = Color(0xFF00619B)
val BlueColor = Color(0xFF0079C2)
val WhiteColor = Color(0xFFFFFFFF)
val BlackColor = Color(0xFF000000)
val AlmostBlackColor = Color(0xFF1B2124)
val LightGreyColor = Color(0xFFC1C1C1)
val LightGreyColor2 = Color(0xFFEEEEEE)
val LightGreyColor3 = Color(0xFFF8F9FB)
val DarkGreyColor = Color(0xFF848484)
val LightBlueColor = Color(0xFFF2F8FC)
val LightOrangeColor = Color(0xFFFFF2EB)
val LightGreenColor = Color(0xFFF1FFF9)
val LightBlueColor2 = Color(0xFFEEF6FC)
val ErrorRedColor = Color(0xFFE26379)
val DarkHalfTransparentColor = Color(0x80072435)
val BlueWithOpacity8 = Color(0x140079C2)

data class Colors(
    val main: Main,
    val text: Text,
    val field: Field,
    val button: Button,
    val background: Background,
    val isLight: Boolean
) {

    data class Main(
        val primary: Color,
        val primaryVariant: Color,
        val onPrimary: Color,
        val secondary: Color,
        val secondaryVariant: Color,
        val onSecondary: Color,
        val disabled: Color,
        val onDisabled: Color,
        val error: Color,
        val onError: Color,
        val shadow: Color
    )

    data class Background(
        val primary: Color,
        val primaryVariant: Color,
        val secondary: Color,
        val secondaryVariant: Color,
        val secondaryVariant2: Color,
        val scrimColor: Color
    )

    data class Text(
        val primary: Color,
        val secondary: Color
    )

    data class Field(
        val hint: Color,
        val contentDisabled: Color,
        val backgroundDisabled: Color,
        val backgroundReadOnly: Color
    )

    data class Button(
        val fillPrimary: Color,
        val fillPrimaryDisabled: Color,
        val strokePrimary: Color,
        val strokePrimaryDisabled: Color,
        val onPrimary: Color,
        val onPrimaryDisabled: Color,
        val fillSecondary: Color,
        val fillSecondaryDisabled: Color,
        val strokeSecondary: Color,
        val strokeSecondaryDisabled: Color,
        val onSecondary: Color,
        val onSecondaryDisabled: Color
    )
}

fun lightColors(): Colors =
    Colors(
        main = Colors.Main(
            primary = BlueColor,
            primaryVariant = DarkBlueColor,
            onPrimary = WhiteColor,
            secondary = LakeBlueColor,
            secondaryVariant = DarkBlueColor,
            onSecondary = WhiteColor,
            disabled = LightGreyColor,
            onDisabled = WhiteColor,
            error = ErrorRedColor,
            onError = WhiteColor,
            shadow = BlueWithOpacity8
        ),
        text = Colors.Text(
            primary = AlmostBlackColor,
            secondary = DarkGreyColor
        ),
        field = Colors.Field(
            hint = DarkGreyColor,
            contentDisabled = DarkGreyColor,
            backgroundDisabled = LightGreyColor2,
            backgroundReadOnly = LightGreyColor3
        ),
        button = Colors.Button(
            fillPrimary = BlueColor,
            fillPrimaryDisabled = LightGreyColor,
            strokePrimary = Color.Transparent,
            strokePrimaryDisabled = Color.Transparent,
            onPrimary = WhiteColor,
            onPrimaryDisabled = WhiteColor,
            fillSecondary = Color.Transparent,
            fillSecondaryDisabled = Color.Transparent,
            strokeSecondary = BlueColor,
            strokeSecondaryDisabled = LightGreyColor,
            onSecondary = BlueColor,
            onSecondaryDisabled = LightGreyColor
        ),
        background = Colors.Background(
            primary = WhiteColor,
            primaryVariant = LightBlueColor,
            secondary = LightOrangeColor,
            secondaryVariant = LightGreenColor,
            secondaryVariant2 = LightBlueColor,
            scrimColor = DarkHalfTransparentColor
        ),
        isLight = true
    )

@Composable
fun fieldBackgroundColorFor(backgroundBehindColor: Color) =
    if (backgroundBehindColor == AtomTheme.colors.background) {
        AtomTheme.colors.background
    } else {
        AtomTheme.colors.background
    }

internal val LocalColors = staticCompositionLocalOf { lightColors() }

