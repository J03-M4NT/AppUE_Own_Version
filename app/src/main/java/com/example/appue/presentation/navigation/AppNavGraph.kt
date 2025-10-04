package com.example.appue.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.appue.presentation.auth.LoginScreen
import com.example.appue.presentation.auth.RegisterScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appue.presentation.home.HomeScreen
import com.example.appue.presentation.permissions.GalleryPermissionsScreen

@Composable
fun AppNavGraph(){

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "home"){    // The first path where apps starts

        composable("register") { RegisterScreen(navController) }
        composable("login") { LoginScreen(navController) }

        // The options bar only for this parts
        composable ("home") {
            DrawerScaffold(navController) {
                HomeScreen()
            }
        }

        composable ("permissions") {
            DrawerScaffold(navController) {
                GalleryPermissionsScreen()
            }
        }

        composable ("favorites") {
            DrawerScaffold(navController) {
                Text("Pantalla de favoritos próximamente")
            }
        }

    }

}