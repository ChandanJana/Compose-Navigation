package com.zebra.tutorialapplication.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zebra.tutorialapplication.R
import com.zebra.tutorialapplication.Screen
import kotlinx.coroutines.delay

/**
 * Created by Chandan Jana on 04-08-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    val systemUiController: SystemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.isSystemBarsVisible = false
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = .5f,
            animationSpec = tween(durationMillis = 1000, delayMillis = 300,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                })
        )
        delay(1000L)
        navController.navigate(route = Screen.MainScreen.route){
            // finish Splash screen
            popUpTo(Screen.SplashScreen.route) {
                inclusive = true
            }
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.tulips),
            contentDescription = "flower",
            modifier = Modifier.scale(scale.value)
        )
    }
}