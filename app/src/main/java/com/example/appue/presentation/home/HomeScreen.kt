package com.example.appue.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appue.data.model.CountryModel
import org.w3c.dom.Text
import androidx.compose.foundation.lazy.items

val mockCountries = listOf(
    CountryModel("Colombia", 8, "https://flagcdn.com/w320/co.pn"),
    CountryModel("Ecuador", 3, "https://flagcdn.com/w320/ec.pn"),
    CountryModel("Perú", 62, "https://flagcdn.com/w320/pe.pn"),
    CountryModel("Mexico", 9, "https://flagcdn.com/w320/mx.pn"),
    CountryModel("United States", 1, "https://flagcdn.com/w320/us.pn")

)

@Composable
// Presentation Screen
fun HomeScreen()
{

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        // verticalArrangement = Arrangement.Center,
        // horizontalAlignment = Alignment.CenterHorizontally


    )
    {
        /* TODO
         Fix and center the title text
        */





        // Spacer(modifier = Modifier.weight(1f))
        // Welcome to the principal screen :D
        Text(text = "Bienvenido a la aplicación - Ranking de países FIFA 2025")
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(mockCountries){ country ->
                    Text("Country: ${country.name} - Ranking: ${country.ranking}")
            }
        }


    }

}