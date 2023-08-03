package com.example.firsrtapp.repository

import com.example.firsrtapp.service.CountryService
import com.example.firsrtapp.data.Data
import javax.inject.Inject

class CountryRepository @Inject constructor(private val countryService: CountryService) {

    suspend fun getCountryList(): List<Data> {
        return countryService.getCountryDetails().data
    }
}