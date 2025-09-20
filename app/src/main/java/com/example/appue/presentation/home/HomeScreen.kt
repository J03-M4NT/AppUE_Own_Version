package com.example.appue.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
// Presentation Screen
fun HomeScreen()
{

    Column(
        modifier = Modifier.fillMaxSize(),
        // verticalArrangement = Arrangement.Center,
        // horizontalAlignment = Alignment.CenterHorizontally
    ){
        /* TODO
         Fix and center the title text
        */


        // Spacer(modifier = Modifier.weight(1f))
        // Welcome to the principal screen :D
        Text(text = "Bienvenido a la aplicación")

    }

}