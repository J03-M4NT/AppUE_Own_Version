package com.example.appue.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoriteCountryDAO {

    // Insert FavoriteCountryEntity
    @Insert
    suspend fun insertFavoriteCountry(favoriteCountry: FavoriteCountryEntity)

    // Delete FavoriteCountryEntity
    @Delete
    suspend fun deleteFavoriteCountry(favoriteCountry: FavoriteCountryEntity)

    // Get all favorite countries
    @Query("SELECT * FROM favorite_countries")
    fun getAll(): Flow<List<FavoriteCountryEntity>>



}