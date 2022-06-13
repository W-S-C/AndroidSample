package com.monthlywriting.android.retrofittest.model


import com.squareup.moshi.Json

data class Header(
    @field:Json(name = "resultCode")
    val resultCode: String?,
    @field:Json(name = "resultMsg")
    val resultMsg: String?
)