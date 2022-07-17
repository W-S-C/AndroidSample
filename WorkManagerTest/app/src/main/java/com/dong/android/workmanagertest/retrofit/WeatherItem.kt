package com.dong.android.workmanagertest.retrofit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class WeatherItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "baseDate") val baseDate: String?,
    @ColumnInfo(name = "baseTime") val baseTime: String?,
    @ColumnInfo(name = "category") val category: String?,
    @ColumnInfo(name = "fcstDate") val fcstDate: String?,
    @ColumnInfo(name = "fcstTime") val fcstTime: String?,
    @ColumnInfo(name = "fcstValue") val fcstValue: String?,
    @ColumnInfo(name = "nx") val nx: Int?,
    @ColumnInfo(name = "ny") val ny: Int?,
)