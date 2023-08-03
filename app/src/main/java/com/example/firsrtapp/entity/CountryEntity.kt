package com.example.firsrtapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Country")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val capital: String,
    val iso2: String,
    val iso3: String,
    val name: String
)