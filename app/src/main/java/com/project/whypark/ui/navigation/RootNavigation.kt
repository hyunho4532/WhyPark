package com.project.whypark.ui.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.project.parks_datasource.viewmodel.MovieViewModel
import com.project.whypark.ui.component.item.listOfNavItems
import com.project.whypark.ui.screen.HomeScreen
import com.project.whypark.ui.screen.MovieScreen
import com.project.whypark.ui.screen.ProfileScreen

@Composable
fun RootNavigation(lifecycleOwner: LifecycleOwner, movieViewModel: MovieViewModel) {
    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            NavigationBar (
                modifier = Modifier.height(54.dp)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItems.forEach { navItem ->
                    NavigationBarItem (
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                                  navController.navigate(navItem.route) {
                                      popUpTo(navController.graph.findStartDestination().id) {
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }
                        },
                        icon = {
                               Icon(
                                   imageVector = navItem.icon,
                                   contentDescription = null,
                                   modifier = Modifier
                                       .width(24.dp)
                                       .height(24.dp)
                               )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost (
            navController = navController,
            startDestination = Screen.HomeScreen.name,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(route = Screen.HomeScreen.name) {
                HomeScreen(lifecycleOwner, movieViewModel)
            }

            composable(route = Screen.ProfileScreen.name) {
                ProfileScreen()
            }

            composable(route = Screen.MovieScreen.name) {
                MovieScreen()
            }
        }
    }
}