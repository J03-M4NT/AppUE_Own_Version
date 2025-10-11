package com.example.appue.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.appue.data.model.CountryModel

@Composable
fun CountryList(
    countries: List<CountryModel>,
    favorites: List<String>,
    onToggleFavorite: ((CountryModel) -> Unit)? = null
){
    LazyColumn {
        items(countries) { country ->
            val isFavorite = favorites.contains(country.name)

            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
            ) {

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


                    // Favorites:
                    onToggleFavorite?.let {
                        IconButton(
                            onClick = { it(country) }
                        ) {
                            Icon(
                                imageVector = if(isFavorite) Icons.Filled.Favorite
                                            else Icons.Filled.FavoriteBorder,
                                contentDescription = "Favorito",
                            )
                        }
                    }


                }

            }




        }

    }
}