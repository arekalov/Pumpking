package com.arekalov.commonui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

internal val Typography
    get() = Typography(
        headlineLarge = TextStyle(
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        ),
        headlineMedium = TextStyle(
            fontSize = 22.sp,
            lineHeight = 26.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        ),
        headlineSmall = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        ),
        bodyLarge = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        ),
        bodyMedium = TextStyle(
            fontSize = 13.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        ),
        labelLarge = TextStyle(
            fontSize = 14.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start,
        ),
        labelMedium = TextStyle(
            fontSize = 13.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        ),
    )
