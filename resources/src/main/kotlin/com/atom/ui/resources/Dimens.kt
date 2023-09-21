package com.atom.ui.resources

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val minimum: Dp,
    val xxs: Dp,
    val xs: Dp,
    val s: Dp,
    val n: Dp,
    val m: Dp,
    val e: Dp,
    val l: Dp,
    val xl: Dp,
    val xxl: Dp,
    val xxxl: Dp,
    val xxxxl: Dp,
    val xxxxxl: Dp,
    val xxxxxxl: Dp,
    val buttonSmallMinWidth: Dp,
    val buttonSmallMinHeight: Dp,
    val buttonNormalMinWidth: Dp,
    val boxSize: Dp,
    val buttonNormalMinHeight: Dp,
    val buttonBigMinWidth: Dp,
    val buttonBigMinHeight: Dp,
)

fun defaultDimens(
    minimum: Dp = 1.dp,
    xxs: Dp = 2.dp,
    xs: Dp = 4.dp,
    s: Dp = 8.dp,
    n: Dp = 12.dp,
    m: Dp = 16.dp,
    e: Dp = 20.dp,
    l: Dp = 24.dp,
    xl: Dp = 28.dp,
    xxl: Dp = 32.dp,
    xxxl: Dp = 36.dp,
    xxxxl: Dp = 40.dp,
    xxxxxl: Dp = 44.dp,
    xxxxxxl: Dp = 48.dp,
    buttonSmallMinWidth: Dp = 88.dp,
    buttonSmallMinHeight: Dp = 24.dp,
    buttonNormalMinWidth: Dp = 106.dp,
    boxSize: Dp = 100.dp,
    buttonNormalMinHeight: Dp = 32.dp,
    buttonBigMinWidth: Dp = 144.dp,
    buttonBigMinHeight: Dp = 40.dp,
): Dimens = Dimens(
    minimum,
    xxs,
    xs,
    s,
    n,
    m,
    e,
    l,
    xl,
    xxl,
    xxxl,
    xxxxl,
    xxxxxl,
    xxxxxxl,
    buttonSmallMinWidth,
    buttonSmallMinHeight,
    buttonNormalMinWidth,
    boxSize,
    buttonNormalMinHeight,
    buttonBigMinWidth,
    buttonBigMinHeight
)

val LocalDimens = staticCompositionLocalOf { defaultDimens() }
