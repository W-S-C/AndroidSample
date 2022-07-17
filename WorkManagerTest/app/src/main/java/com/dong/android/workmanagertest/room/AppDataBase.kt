package com.dong.android.workmanagertest.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dong.android.workmanagertest.retrofit.WeatherItem

@Database(
    entities = [WeatherItem::class],
    version = 1,
    exportSchema = false
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}