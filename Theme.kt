package com.example.kotlinhotelpeek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinhotelpeek.screens.*
import com.example.kotlinhotelpeek.ui.theme.KotlinHotelPeekTheme
import androidx.compose.runtime.saveable.rememberSaveable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkTheme by rememberSaveable { mutableStateOf(false) }

            KotlinHotelPeekTheme(darkTheme = darkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavigation(
                        navController = navController,
                        onThemeToggle = { darkTheme = !darkTheme },
                        darkTheme = darkTheme
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    onThemeToggle: () -> Unit,
    darkTheme: Boolean
) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("home") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate("home") },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("HotelResults") {
            HotelResultsScreen(navController)
        }
        composable("HotelDetails") {
            HotelDetailsScreen(navController)
        }
        composable("favorites") {
            FavoritesScreen(navController)
        }
        composable("Settings") {
            SettingsScreen(
                navController = navController,
                isDarkTheme = darkTheme,
                onToggleTheme = onThemeToggle
            )
        }
        composable("MyAccount") {
            MyAccountScreen(navController)
        }

    }
}
