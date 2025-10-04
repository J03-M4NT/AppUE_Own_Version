package com.example.appue.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScaffold(navController: NavController, content: @Composable () -> Unit){

    // The SideMenu. By default is colapsed and can be opened
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,  // Close/Colapsed by default
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(12.dp))
                Text("Menú Principal", modifier = Modifier.padding(16.dp))   // Give alineation with the options

                // Home Item
                NavigationDrawerItem(
                    label = {Text("Inicio")},
                    selected = false,   // In the begin is not selected, so its false (3 BARS ICON)
                    onClick = {
                        navController.navigate("home")
                        scope.launch { drawerState.close() }    // Close the drawer after click
                    }
                )


                // Permissions Item
                NavigationDrawerItem(
                    label = {Text("Permisos")},
                    selected = false,   // In the begin is not selected, so its false
                    onClick = {
                        navController.navigate("permissions")
                        scope.launch { drawerState.close() }    // Close the drawer after click
                    }
                )


                // Favorites Item
                NavigationDrawerItem(
                    label = {Text("Favoritos")},
                    selected = false,   // In the begin is not selected, so its false
                    onClick = {
                        navController.navigate("favorites")
                        scope.launch { drawerState.close() }    // Close the drawer after click
                    }
                )





            }
        }

    ) {

        // Icons for drawable items
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("App UESAN") },
                    navigationIcon = {
                        //----------------
                        IconButton(

                            onClick = {
                                scope.launch { drawerState.open() }
                            }

                        ){
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                        //----------------
                    }

                )

            }
        ) {

            paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)){
                content()   // Show all the content in the app (Home, Permissions, Favorites, etc)
            }

        }

    }


}