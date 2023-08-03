package com.example.firsrtapp.di

import android.app.Application
import android.content.Context
import com.example.firsrtapp.dao.FirstAppDao
import com.example.firsrtapp.db.FirstAppDb
import com.example.firsrtapp.service.CountryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /*@Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient {
       return OkHttpClient.Builder()
           .build()
    }*/

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://countriesnow.space/api/v0.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit1(retrofit: Retrofit): CountryService {
        return retrofit.create(CountryService::class.java)
    }

    @Singleton
    @Provides
    fun provideFirstAppDb(context: Application): FirstAppDb {
        return FirstAppDb.getFirstAppDb(context)
    }

    @Singleton
    @Provides
    fun providesFistAppDao(db: FirstAppDb): FirstAppDao {
        return db.getFirstAppDao()
    }
}