package com.zebra.tutorialapplication

/**
 * Created by Chandan Jana on 04-08-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
sealed class Screen (val route: String){
    object SplashScreen : Screen("splash_screen")
    object MainScreen : Screen("main_screen")
    object HomeScreen : Screen("home_screen")
    object ChatScreen : Screen("chat_screen")
    object SettingScreen : Screen("setting_screen")
}