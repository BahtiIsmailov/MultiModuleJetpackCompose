package com.atom.ui.resources

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

val koratakiFontFamily = FontFamily(
    Font(R.font.korataki, FontWeight.Normal),
    Font(R.font.korataki_bold, FontWeight.Bold),
    Font(R.font.korataki_extrabold, FontWeight.ExtraBold),
    Font(R.font.korataki_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.korataki_bolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.korataki_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.korataki_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.korataki_light, FontWeight.Light),
    Font(R.font.korataki_extralight, FontWeight.ExtraLight)
)
