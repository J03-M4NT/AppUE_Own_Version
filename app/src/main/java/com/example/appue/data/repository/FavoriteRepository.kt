package com.example.appue.data.repository

import com.example.appue.data.local.FavoriteCountryDAO
import com.example.appue.data.local.FavoriteCountryEntity
import kotlinx.coroutines.flow.Flow

class FavoriteRepository (private val dao: FavoriteCountryDAO) {

    // Insert a country into the database
    suspend fun insert(country: FavoriteCountryEntity)
        = dao.insertFavoriteCountry(country)

    // Delete a country from the database
    suspend fun delete(country: FavoriteCountryEntity)
        = dao.deleteFavoriteCountry(country)

    // Get all countries from the database
    fun getAll(): Flow<List<FavoriteCountryEntity>>
        = dao.getAll()





}