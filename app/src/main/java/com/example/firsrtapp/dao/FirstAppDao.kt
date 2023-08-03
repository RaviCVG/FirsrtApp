package com.example.firsrtapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firsrtapp.entity.CountryEntity

@Dao
interface FirstAppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(countryList: List<CountryEntity>)

    @Query("Select * from Country")
    suspend fun getCountryData(): List<CountryEntity>

    @Query("DELETE FROM Country")
    suspend fun deleteRecords()
}