package com.project.whypark.ui.component.item

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.project.whypark.R
import com.project.whypark.ui.navigation.Screen

data class BottomNavigationItem (
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf (
    BottomNavigationItem (
        label = "Home",
        icon = Icons.Default.Home,
        route = Screen.HomeScreen.name
    ),

    BottomNavigationItem (
        label = "Profile",
        icon = Icons.Default.Person,
        route = Screen.ProfileScreen.name
    )
)