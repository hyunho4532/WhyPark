package com.project.whypark.ui.component.item

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import com.project.parks_domain.entity.BottomNavigation
import com.project.whypark.ui.navigation.Screen

val listOfNavItems = listOf (
    BottomNavigation (
        label = "홈",
        icon = Icons.Default.Home,
        route = Screen.HomeScreen.name
    ),

    BottomNavigation (
        label = "영화",
        icon = Icons.Default.Favorite,
        route = Screen.MovieScreen.name
    ),

    BottomNavigation (
        label = "프로필",
        icon = Icons.Default.Person,
        route = Screen.ProfileScreen.name
    )
)