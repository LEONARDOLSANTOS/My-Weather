package com.leonardolsantos.myweather.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.leonardolsantos.myweather.dao.CityDatabaseDao
import com.leonardolsantos.myweather.model.CityDatabase

@Database(entities = arrayOf(CityDatabase::class), version = 1)
abstract class MyWeatherAppDatabase: RoomDatabase() {
    abstract  fun cityDatabaseDao(): CityDatabaseDao

    companion object{
        private var INSTANCE: MyWeatherAppDatabase? = null
        fun getInstance(context: Context): MyWeatherAppDatabase?{

            if(INSTANCE == null){
                synchronized(MyWeatherAppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MyWeatherAppDatabase::class.java, "myweather.db" )
                        .allowMainThreadQueries().build()
                }
            }
            return  INSTANCE
        }
    }
}