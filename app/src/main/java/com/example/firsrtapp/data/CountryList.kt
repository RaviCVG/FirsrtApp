package com.example.firsrtapp.data

import androidx.room.ColumnInfo

data class CountryList(
    val data: List<Data>,
    val error: Boolean,
    val msg: String
)