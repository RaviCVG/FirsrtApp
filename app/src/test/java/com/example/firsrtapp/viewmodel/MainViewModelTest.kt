package com.example.firsrtapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.firsrtapp.data.Data
import com.example.firsrtapp.repository.CountryRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

internal class MainViewModelTest {

    private val countryRepository: CountryRepository = mockk()

    private lateinit var subject:MainViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        subject = MainViewModel(countryRepository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearUp() {
        Dispatchers.resetMain()
    }

    @Test
    fun getCountryList() {
         val data: Data = mockk()
         val data1: Data = mockk()
        data.apply {
            every { name } returns "ravi"
            every { capital } returns "ravi capital"
        }
        data1.apply {
            every { name } returns "ravi 1"
            every { capital } returns "ravi 1 capital"
        }

        coEvery { countryRepository.getCountryList() } returns listOf(data,data1)

        subject.getCountryList()

        assertEquals(data.name, subject.countryLiveData.value?.get(0)?.name ?: null)
        assertEquals(data1.name, subject.countryLiveData.value?.get(1)?.name ?: null)
    }
}