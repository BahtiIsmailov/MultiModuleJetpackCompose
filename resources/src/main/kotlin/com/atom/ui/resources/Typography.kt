package com.atom.ui.resources

import androidx.compose.material.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

fun defaultTypography() = Typography(
    defaultFontFamily = FontFamily.SansSerif,
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp,
        lineHeight = 24.sp
    ),
    h1 = TextStyle(
        fontFamily = koratakiFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 100.sp,
        letterSpacing = 0.15.sp,
        lineHeight = 40.sp
    ),
    h2 = TextStyle(
        fontFamily = koratakiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 68.sp,
        letterSpacing = 0.15.sp,
        lineHeight = 40.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    overline = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    )
)

internal val LocalTypography = staticCompositionLocalOf { defaultTypography() }

