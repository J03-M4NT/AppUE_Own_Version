package com.example.appue.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appue.data.model.CountryModel
import org.w3c.dom.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

val mockCountries = listOf(
    CountryModel("Colombia", 8, "https://flagcdn.com/w320/co.png"),
    CountryModel("Ecuador", 3, "https://flagcdn.com/w320/ec.png"),
    CountryModel("Perú", 62, "https://flagcdn.com/w320/pe.png"),
    CountryModel("Mexico", 9, "https://flagcdn.com/w320/mx.png"),
    CountryModel("United States", 1, "https://flagcdn.com/w320/us.png")

)

@Composable
// Presentation Screen
fun HomeScreen() {

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
                Text("Country: ${country.name}")

                Card(
                    modifier = Modifier.fillMaxSize().padding(vertical = 8.dp)
                ){
                    Row(modifier = Modifier.padding(12.dp)) {

                        Image(
                            contentDescription = country.name,
                            modifier = Modifier.size(64.dp),
                            // contentScale = ContentScale.Crop,    // Scale the images, is better without this xd
                            painter = rememberAsyncImagePainter(country.imageURL)
                        )

                        Spacer(modifier = Modifier.width(8.dp))   // Space between images and description
                        Column {
                            Text(text = country.name, style = MaterialTheme.typography.titleMedium)
                            Text(text = "Ranking FIFA: ${country.ranking}")
                        }
                    }




                }


                    //Text("Country: ${country.name} - Ranking: ${country.ranking}")
            }
        }


    }

}