package com.example.firsrtapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firsrtapp.dao.FirstAppDao
import com.example.firsrtapp.entity.CountryEntity

@Database(entities = [CountryEntity::class], version = 1, exportSchema = false)
abstract class FirstAppDb : RoomDatabase() {

    abstract fun getFirstAppDao(): FirstAppDao

    companion object {
        private const val DB_NAME = "FIRST_APP_DB"

        @Volatile
        private var dbInstance:FirstAppDb? = null

        fun getFirstAppDb(context: Context): FirstAppDb {
            synchronized(this) {
                if(dbInstance == null) {
                    dbInstance =  Room.databaseBuilder(context.applicationContext, FirstAppDb::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
           return dbInstance!!
        }

    }
}
