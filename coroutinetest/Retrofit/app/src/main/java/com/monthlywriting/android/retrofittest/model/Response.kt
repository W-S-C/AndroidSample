package com.monthlywriting.android.retrofittest.model


import com.squareup.moshi.Json

data class Response(
    @field:Json(name = "body")
    val body: Body?,
    @field:Json(name = "header")
    val header: Header?
)