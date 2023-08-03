package com.example.firsrtapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsrtapp.data.Data
import com.example.firsrtapp.entity.CountryEntity
import com.example.firsrtapp.providers.DispatchersProvider
import com.example.firsrtapp.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val countryRepo: CountryRepository,
private val dispatchersProvider: DispatchersProvider): ViewModel() {

    private var countryMutableLiveData = MutableLiveData<List<CountryEntity>>()
    var countryLiveData:LiveData<List<CountryEntity>> = countryMutableLiveData

    fun getCountryList() {
        viewModelScope.launch(dispatchersProvider.getIoDispatcher()) {
            val countriesList = countryRepo.getCountryList()
            withContext(dispatchersProvider.getMainDispatcher()) {
                countryMutableLiveData.value = countriesList
            }
        }
    }
}