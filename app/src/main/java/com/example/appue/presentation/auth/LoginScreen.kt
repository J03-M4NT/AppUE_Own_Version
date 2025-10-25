package com.example.appue.presentation.auth

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appue.data.remote.firebase.FirebaseAuthManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
// Login Screen :D
fun LoginScreen(navController: NavController){

    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }

    // ****************
    val context = LocalContext.current


    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // Spacer for the title
        Spacer(modifier = Modifier.height(16.dp))

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

        Spacer(modifier = Modifier.height(16.dp))   // Spacer for the button :)


        // -----------------------------------------------------------------------------


        // Button actions for validate the login and redirection to the main screen
        Button( onClick = {
            if( email.isNotBlank() && password.isNotBlank()) {

                // Firebase auth
                CoroutineScope(Dispatchers.Main).launch {
                    val result = FirebaseAuthManager.loginuser(email, password)

                    if ( result.isSuccess ){

                        navController.navigate("home")

                    } else {

                        val error = result.exceptionOrNull()?.message ?: "Error desconocido"

                        // Snackbar
                        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()

                    }

                }

            }


        }, modifier = Modifier.fillMaxWidth() // Take all the space for the button c:
        ) {
           Text("Iniciar Sesión")
        }



    }

}