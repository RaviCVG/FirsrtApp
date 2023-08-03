package com.example.firsrtapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsrtapp.data.Data
import com.example.firsrtapp.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val countryRepo: CountryRepository): ViewModel() {

    private var countryMutableLiveData = MutableLiveData<List<Data>>()
    var countryLiveData:LiveData<List<Data>> = countryMutableLiveData

    fun getCountryList() {
        viewModelScope.launch {
            val countriesList = countryRepo.getCountryList()
            countryMutableLiveData.value = countriesList
        }
    }
}