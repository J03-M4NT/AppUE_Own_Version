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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.appue.data.local.AppDatabase
import com.example.appue.data.local.FavoriteCountryEntity
import com.example.appue.data.repository.FavoriteRepository
import com.example.appue.presentation.components.CountryList
import com.example.appue.presentation.favorites.FavoritesViewModel
import com.example.appue.presentation.favorites.FavoritesViewModelFactory

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

    val context = LocalContext.current
    val db = remember { AppDatabase.getInstance(context) }
    val repository = remember { FavoriteRepository(db.favoriteCountryDao) }
    val viewModel: FavoritesViewModel = viewModel (factory = FavoritesViewModelFactory(repository))

    val favorites by viewModel.favorites.collectAsState()

    val favoritesNames = favorites.map { it.name }

    Spacer(modifier = Modifier.height(8.dp))

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

        CountryList(
            countries = mockCountries,
            favorites = favoritesNames,

            // This works like a toggle for the favorites button in the country list
            onToggleFavorite = { country ->
                val isFav = favoritesNames.contains(country.name)
                if (isFav) {
                    favorites.find {it.name == country.name}?.let {
                        viewModel.deleteFavorite(it)
                    }
                } else {
                    viewModel.insertFavorite(
                        FavoriteCountryEntity(name = country.name
                            , ranking = country.ranking
                            , imageUrl = country.imageURL)
                    )
                }
            }
        )






        // Old Stuff
        /*

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

        */

    }

}