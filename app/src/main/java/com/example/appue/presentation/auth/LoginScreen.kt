package com.example.appue.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
// Login Screen :D
fun LoginScreen(){

    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // Title for login
        Text( text = "Iniciar Sesión", style = MaterialTheme.typography.titleLarge )

        /* // Old Code
        Text( text = "Correo electrónico" )
        TextField(value = email, onValueChange = { email = it })
        */

        //Outlines text field for email ( This create the input for the email c: )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            placeholder = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth() // All space for email textbox
        )


        //OutLined text field for password ( This create the input for the password c: )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            placeholder = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth() // All space for password textbox
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button( onClick = {
            /*TODO*/
        }, modifier = Modifier.fillMaxWidth() // Take all the space for the button c:
        ) {
           Text("Iniciar Sesión")
        }



    }

}