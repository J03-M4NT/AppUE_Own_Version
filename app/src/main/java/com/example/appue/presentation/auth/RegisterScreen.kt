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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appue.data.remote.firebase.FirebaseAuthManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
// Register Screen
fun RegisterScreen(navController: NavHostController) {

    var name by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    var confirmPassword by remember { mutableStateOf(value = "") }

    // *******
    val context = LocalContext.current


    Column (
        modifier = Modifier.padding(16.dp)
    ){
        // Spacer for the title
        Spacer(modifier = Modifier.height(16.dp))

        // Title for register
        Text( text = "Registrarse", style = MaterialTheme.typography.titleLarge )

        // Outlined text field for name
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            placeholder = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )


        // Outlined text field for email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            placeholder = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )


        // Outlined text field for password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            placeholder = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )


        // Outlined text field for confirm password
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar contraseña") },
            placeholder = { Text("Confirmar contraseña") },
            modifier = Modifier.fillMaxWidth()
        )


        // - - - - - - - - - - - - - - - - - - - - - -
        Spacer(modifier = Modifier.height(16.dp))

        // Button for register
        Button( onClick = {

            if( email.isNotBlank()
                && password.isNotBlank()
                && password == confirmPassword ){

                // We add the firebase auth here
                CoroutineScope(Dispatchers.Main).launch {
                    val result = FirebaseAuthManager.registerUser(name, email, password)

                    if (result.isSuccess){

                        navController.navigate("register")

                    } else {

                        val error = result.exceptionOrNull()?.message ?: "Error desconocido"

                        // Snackbar
                        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()


                    }



                }


            }



        }, modifier = Modifier.fillMaxWidth()
            ) {
            Text("Registrarse")
        }


    }


}