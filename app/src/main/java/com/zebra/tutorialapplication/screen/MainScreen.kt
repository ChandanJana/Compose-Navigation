package com.zebra.tutorialapplication.screen

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zebra.tutorialapplication.BottomNavigationBar
import com.zebra.tutorialapplication.Navigation
import com.zebra.tutorialapplication.R
import com.zebra.tutorialapplication.Screen
import com.zebra.tutorialapplication.model.BottomNavItem

/**
 * Created by Chandan Jana on 04-08-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
@Composable
fun MainScreen(navController: NavController) {
    //val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Instagram",
                        route = Screen.HomeScreen.route,
                        icon = painterResource(id = R.drawable.instagram)
                    ),
                    BottomNavItem(
                        name = "Medica",
                        route = Screen.ChatScreen.route,
                        icon = painterResource(id = R.drawable.medical),
                        badgeCount = 25
                    ),
                    BottomNavItem(
                        name = "More",
                        route = Screen.SettingScreen.route,
                        icon = painterResource(id = R.drawable.more),
                        badgeCount = 214
                    ),
                ),
                navController = navController,
                onItemClick = {
                    Log.d("TAGG", "BottomNavItem $it")
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Log.d("TAGG", "BottomNavItem padding $it")
        Navigation(navController = navController as NavHostController, true)
    }
}