package com.example.playai.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.playai.R

// Títulos, nomes de jogos e números grandes
val DmSerifDisplay = FontFamily(
    Font(R.font.dm_serif_display_regular, FontWeight.Normal)
)

// Texto, botões e rótulos
val DmSans = FontFamily(
    Font(R.font.dm_sans_regular, FontWeight.Normal),
    Font(R.font.dm_sans_medium, FontWeight.Medium),
    Font(R.font.dm_sans_semibold, FontWeight.SemiBold),
    Font(R.font.dm_sans_bold, FontWeight.Bold)
)

// Base do Material 3 com DM Sans em todos os papéis; os que o design usa são ajustados abaixo
private val Base = Typography()

val Typography = Typography(
    displayLarge = Base.displayLarge.copy(fontFamily = DmSerifDisplay),
    displayMedium = TextStyle(
        fontFamily = DmSerifDisplay,
        fontSize = 48.sp,
        lineHeight = 48.sp,
        letterSpacing = (-0.5).sp
    ),
    displaySmall = Base.displaySmall.copy(fontFamily = DmSerifDisplay),
    headlineLarge = TextStyle(
        fontFamily = DmSerifDisplay,
        fontSize = 40.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = DmSerifDisplay,
        fontSize = 30.sp,
        lineHeight = 30.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = DmSerifDisplay,
        fontSize = 26.sp,
        lineHeight = 30.sp
    ),
    titleLarge = Base.titleLarge.copy(fontFamily = DmSans, fontWeight = FontWeight.Bold),
    titleMedium = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    titleSmall = Base.titleSmall.copy(fontFamily = DmSans, fontWeight = FontWeight.Bold),
    bodyLarge = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 22.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodySmall = Base.bodySmall.copy(fontFamily = DmSans),
    labelLarge = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    labelMedium = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 18.sp
    ),
    // Rótulos em caixa alta ("DESCOBRIR"): o texto vai com .uppercase()
    labelSmall = TextStyle(
        fontFamily = DmSans,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 2.sp
    )
)
