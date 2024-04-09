package com.zebra.tutorialapplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zebra.tutorialapplication.screen.InstagramScreen
import com.zebra.tutorialapplication.screen.MainScreen
import com.zebra.tutorialapplication.screen.MedicalScreen
import com.zebra.tutorialapplication.screen.MoreScreen
import com.zebra.tutorialapplication.screen.SplashScreen

/**
 * Created by Chandan Jana on 02-08-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
@Composable
fun Navigation(navController: NavHostController, fromMainScreen: Boolean = false) {
    var startDestination by remember {
        mutableStateOf(Screen.SplashScreen.route)
    }
    if (fromMainScreen) {
        startDestination = Screen.HomeScreen.route
    }
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(route = Screen.HomeScreen.route) {
            InstagramScreen(navController)
        }
        composable(route = Screen.ChatScreen.route) {
            MedicalScreen(navController)
        }
        composable(route = Screen.SettingScreen.route) {
            MoreScreen(navController)
        }
    }
}
