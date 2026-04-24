package com.helbertquesada.explora_colombia_app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.helbertquesada.explora_colombia_app.ui.theme.HomeScreen

@Composable
fun NavigationApp() {
    val auth = Firebase.auth
    val currentUser = auth.currentUser
    val startDestination = if (currentUser != null) "home" else "login"

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = "login") {
            LoginScreen(
                onSuccessfulLogin = {
                    navController.navigate("home") {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onClickRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable(route = "register") {
            RegisterScreen(
                onClickBack = {
                    navController.popBackStack()
                },
                onSuccessfulRegister = {
                    navController.navigate("home") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(route = "home") {
            HomeScreen(
                onClickLogout = {
                    navController.navigate("login") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}
