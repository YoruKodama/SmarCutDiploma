package com.example.smartslicerapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartcutapp.theme.*

@Composable
fun MainScreen(
    onNavigateToCubeSlicer: () -> Unit,
    onNavigateToBladeSlicer: () -> Unit,
    onNavigateToRecipes: () -> Unit,
    onNavigateToWeighing: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    var isConnected by remember { mutableStateOf(false) }

    AppTheme {
        val colors = MaterialTheme.colorScheme

        Scaffold(containerColor = colors.background) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 16.dp, vertical = 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text(
                    text = "SmartCut App",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.primary
                )
                Text(
                    "Выбери режим нарезки",
                    fontSize = 16.sp,
                    color = colors.onBackground.copy(0.7f)
                )

                Spacer(Modifier.height(6.dp))

                ConnectionButton(
                    isConnected = isConnected,
                    onClick = { isConnected = !isConnected }
                )

                Text(
                    text = "Режимы нарезки",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.primary
                )

                ModeCard(
                    icon = Icons.Default.ContentCut,
                    title = "Нарезка кубиками",
                    description = "Нарежьте продукты кубиками",
                    onClick = onNavigateToCubeSlicer
                )

                ModeCard(
                    Icons.Default.ContentCut,
                    "Нарезка слайсами",
                    "Нарежьте продукты тонкими ломтиками",
                    onNavigateToBladeSlicer
                )

                ModeCard(
                    icon = Icons.Default.ContentCut,
                    title = "Режим рецептов",
                    description = "Готовить по рецепту с порциями",
                    onClick = onNavigateToRecipes
                )

                ModeCard(
                    Icons.Default.ContentCut,
                    "Режим взвешивания",
                    "Точное взвешивание ингредиентов",
                    onNavigateToWeighing
                )

                Spacer(Modifier.weight(1f))

                OutlinedButton(
                    onClick = onNavigateToSettings,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Orange),
                    border = androidx.compose.foundation.BorderStroke(2.dp, Orange)
                ) {
                    Text(
                        "Настройки",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ConnectionButton(isConnected: Boolean, onClick: () -> Unit) {
    val bgColor = if (isConnected) Green else DarkDisconnected
    val text = if (isConnected) "Подключено к ESP32" else "Отключено от ESP32"
    val icon = if (isConnected) "●" else "○"

    Surface(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        color = bgColor,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = icon,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = White
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = White
            )
        }
    }
}

@Composable
private fun ModeCard(
    icon: ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colors.secondary),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                Modifier.size(48.dp),
                color = OrangeAlpha,
                shape = RoundedCornerShape(12.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(icon, null, tint = White)
                }
            }

            Spacer(Modifier.width(16.dp))

            Column {
                Text(
                    title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colors.onSecondary
                )
                Text(
                    description,
                    fontSize = 14.sp,
                    color = colors.onSecondary.copy(0.8f)
                )
            }
        }
    }
}