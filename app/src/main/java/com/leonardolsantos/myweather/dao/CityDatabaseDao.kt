package com.leonardolsantos.myweather.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leonardolsantos.myweather.model.CityDatabase
@Dao
interface CityDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(cityDatabase: CityDatabase)

    @Query("SELECT * FROM citydatabase order by cityName")
    fun getAllCityDatabase(): List<CityDatabase>
}