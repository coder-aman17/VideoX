package com.example.videdox.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.videdox.Presentation.Screens.HomeScreen
import kotlinx.serialization.Serializable

@Composable

fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoutes.HomeScreen){
        composable<NavigationRoutes.HomeScreen> {
            HomeScreen(navController)

        }
        composable<NavigationRoutes.PlayerScreen> {
            }

    }
}

sealed class NavigationRoutes{
    @Serializable
    object HomeScreen
    @Serializable
    data class PlayerScreen(val videoUrl: String)

}