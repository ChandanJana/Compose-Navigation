package com.zebra.tutorialapplication.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zebra.tutorialapplication.ui.theme.DeepBlue

/**
 * Created by Chandan Jana on 04-08-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
@Composable
fun MoreScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.isSystemBarsVisible = true
        systemUiController.setStatusBarColor(
            color = Color.White,
            darkIcons = true,
        )
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Mome screen")
    }
}