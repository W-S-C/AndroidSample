package com.monthlywriting.android.retrofittest.model


import com.squareup.moshi.Json

data class Items(
    @field:Json(name = "item")
    val item: List<Item?>?
)