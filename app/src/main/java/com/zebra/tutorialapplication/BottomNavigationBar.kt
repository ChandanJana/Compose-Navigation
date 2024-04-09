package com.zebra.tutorialapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zebra.tutorialapplication.model.BottomNavItem

/**
 * Created by Chandan Jana on 02-08-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Text(
                                        text = item.badgeCount.toString(),
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .background(color = Color.Red)
                                            .padding(start = 5.dp, end = 5.dp),
                                        fontSize = 12.sp,
                                        color = Color.White
                                    )
                                }
                            ) {
                                Icon(
                                    painter = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                painter = item.icon,
                                contentDescription = item.name
                            )
                        }
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 13.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            )
        }
    }
}