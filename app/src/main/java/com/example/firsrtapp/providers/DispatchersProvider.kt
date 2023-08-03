package com.example.firsrtapp.providers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatchersProvider @Inject constructor() {

    fun getIoDispatcher(): CoroutineDispatcher{
        return Dispatchers.IO
    }

    fun getMainDispatcher(): CoroutineDispatcher{
        return Dispatchers.Main
    }

    fun getDefaultDispatcher(): CoroutineDispatcher{
        return Dispatchers.Default
    }

    fun getUnconfinedDispatcher(): CoroutineDispatcher{
        return Dispatchers.Unconfined
    }
}