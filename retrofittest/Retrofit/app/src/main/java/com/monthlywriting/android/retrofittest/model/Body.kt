package com.monthlywriting.android.retrofittest.model


import com.squareup.moshi.Json

data class Body(
    @field:Json(name = "dataType")
    val dataType: String?,
    @field:Json(name = "items")
    val items: Items?,
    @field:Json(name = "numOfRows")
    val numOfRows: Int?,
    @field:Json(name = "pageNo")
    val pageNo: Int?,
    @field:Json(name = "totalCount")
    val totalCount: Int?
)