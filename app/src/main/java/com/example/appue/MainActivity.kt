package com.example.appue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appue.presentation.auth.LoginScreen
import com.example.appue.presentation.auth.RegisterScreen
import com.example.appue.presentation.navigation.AppNavGraph
import com.example.appue.ui.theme.AppUETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppUETheme {


                AppNavGraph()
                /*
                General Navigation, so is better compared to
                the login and register screens functions
                */

            }
        }
    }
}