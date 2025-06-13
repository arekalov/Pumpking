package com.arekalov.commonui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

internal val Typography
    get() = Typography(
        headlineLarge = TextStyle(
            fontSize = 30.sp,
            lineHeight = (30 * 1.4).sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        ),
        headlineMedium = TextStyle(
            fontSize = 22.sp,
            lineHeight = (22 * 1.4).sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        ),
        headlineSmall = TextStyle(
            fontSize = 19.sp,
            lineHeight = (19 * 1.4).sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        ),
        bodyMedium = TextStyle(
            fontSize = 14.sp,
            lineHeight = (14 * 1.4).sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
        ),
        bodySmall = TextStyle(
            fontSize = 12.sp,
            lineHeight = (12 * 1.4).sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start,
        ),
    )
