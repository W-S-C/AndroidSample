package com.dong.android.workmanagertest.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dong.android.workmanagertest.retrofit.WeatherApiResponse
import com.dong.android.workmanagertest.retrofit.WeatherItem

@Dao
interface ItemDao {

    @Query("Select * FROM item")
    fun getAll(): List<WeatherItem>?

    @Insert
    fun insertList(item: WeatherItem)
}