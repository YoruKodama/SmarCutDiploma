package com.example.smartcutapp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Orange,
    onPrimary = White,

    background = DarkCard,
    onBackground = DarkTextPrimary,

    surface = DarkCard,
    onSurface = DarkTextPrimary,

    secondary = LightOrange,
    onSecondary = White,
)

private val LightColorScheme = lightColorScheme(
    primary = Orange,
    onPrimary = White,

    background = LightBackground,
    onBackground = LightTextPrimary,

    surface = LightCard,
    onSurface = LightTextPrimary,

    secondary = LightOrange,
    onSecondary = White,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}