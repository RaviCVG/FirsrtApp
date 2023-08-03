package com.example.firsrtapp.repository

import com.example.firsrtapp.dao.FirstAppDao
import com.example.firsrtapp.service.CountryService
import com.example.firsrtapp.data.Data
import com.example.firsrtapp.entity.CountryEntity
import javax.inject.Inject

class CountryRepository @Inject constructor(private val countryService: CountryService, private val firstAppDao: FirstAppDao) {

    suspend fun getCountryList(): List<CountryEntity> {
        firstAppDao.deleteRecords()

        val networkCountryDta = countryService.getCountryDetails().data
        val countryEntityList = networkCountryDta.map {
            CountryEntity(0, it.capital, it.iso2, it.iso3, it.name)
        }.toList()
        firstAppDao.insert(countryEntityList)
        return firstAppDao.getCountryData()
    }
}