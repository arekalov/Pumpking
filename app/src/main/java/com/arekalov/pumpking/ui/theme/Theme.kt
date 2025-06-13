package com.arekalov.pumpking.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

val DarkColorScheme: ColorScheme
    get() = lightColorScheme(
        primary = darkPrimary,
        secondary = darkSecondary,
        onPrimary = darkOnPrimary,
        onSecondary = darkOnSecondary,
        surface = darkSurface,
        surfaceVariant = darkSurfaceVariant,
        onSurface = darkOnSurface,
        onSurfaceVariant = darkOnSurfaceVariant,
        primaryContainer = darkContainer,
        onPrimaryContainer = darkOnContainer,
        secondaryContainer = darkContainerVariant,
        onSecondaryContainer = darkOnContainerVariant,
    )

private val LightColorScheme: ColorScheme
    get() = lightColorScheme(
        primary = lightPrimary,
        secondary = lightSecondary,
        onPrimary = lightOnPrimary,
        onSecondary = lightOnSecondary,
        surface = lightSurface,
        surfaceVariant = lightSurfaceVariant,
        onSurface = lightOnSurface,
        onSurfaceVariant = lightOnSurfaceVariant,
        primaryContainer = lightContainer,
        onPrimaryContainer = lightOnContainer,
        secondaryContainer = lightContainerVariant,
        onSecondaryContainer = lightOnContainerVariant,
    )

internal data class PumpkingUniversalColors(
    val accentRed: Color,
    val accentRedVariant: Color,
    val accentGreen: Color,
    val accentGreenVariant: Color,
    val accentBlue: Color,
    val accentYellow: Color,
    val accentLightBlue: Color,
    val accentPurple: Color,
    val accentOrange: Color,
    val accentCyan: Color,
    val accentGrey: Color,
)

private val PumpkingUniversalColorsPalette: PumpkingUniversalColors
    get() = PumpkingUniversalColors(
        accentRed = accentRed,
        accentRedVariant = accentRedVariant,
        accentGreen = accentGreen,
        accentGreenVariant = accentGreenVariant,
        accentBlue = accentBlue,
        accentYellow = accentYellow,
        accentLightBlue = accentLightBlue,
        accentPurple = accentPurple,
        accentOrange = accentOrange,
        accentCyan = accentCyan,
        accentGrey = accentGrey,
    )

@Composable
fun PumpkingTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val themeColors = if (isDarkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalPaletteColors provides PumpkingUniversalColorsPalette
    ) {
        MaterialTheme(
            colorScheme = themeColors,
            typography = Typography,
            content = content
        )
    }
}
