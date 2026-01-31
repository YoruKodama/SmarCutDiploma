package com.example.smartcutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.example.smartcutapp.theme.AppTheme
import com.example.smartslicerapp.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MainScreen(
                    onNavigateToCubeSlicer = { /* TODO */ },
                    onNavigateToBladeSlicer = { /* TODO */ },
                    onNavigateToRecipes = { /* TODO */ },
                    onNavigateToWeighing = { /* TODO */ },
                    onNavigateToSettings = { /* TODO */ }
                )
            }
        }
    }
}