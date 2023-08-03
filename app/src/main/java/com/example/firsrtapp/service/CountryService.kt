package com.example.firsrtapp.service

import com.example.firsrtapp.data.CountryList
import retrofit2.http.GET

interface CountryService {

    @GET("countries/capital")
    suspend fun getCountryDetails(): CountryList
}