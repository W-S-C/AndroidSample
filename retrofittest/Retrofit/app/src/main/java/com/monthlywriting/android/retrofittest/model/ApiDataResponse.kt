package com.monthlywriting.android.retrofittest.model


import com.squareup.moshi.Json

data class ApiDataResponse(
    @field:Json(name = "response")
    val response: Response?
)