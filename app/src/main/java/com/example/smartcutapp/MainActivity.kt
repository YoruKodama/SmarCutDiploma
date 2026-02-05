package com.example.smartcutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier

import com.example.smartcutapp.theme.AppTheme
import com.example.smartcutapp.ui.screen.list.ListScreen
import com.example.smartslicerapp.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                //MainScreen(
//                    onNavigateToCubeSlicer = { /* TODO */ },
//                    onNavigateToBladeSlicer = { /* TODO */ },
//                    onNavigateToRecipes = { /* TODO */ },
//                    onNavigateToWeighing = { /* TODO */ },
//                    onNavigateToSettings = { /* TODO */ }
                //)
                ListScreen()
            }
        }
    }
}