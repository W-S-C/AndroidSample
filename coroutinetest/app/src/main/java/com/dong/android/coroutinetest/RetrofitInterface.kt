package com.dong.android.coroutinetest

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceInterface {
    // getUltraSrtFcst : 초단기 예보 조회 + 인증키
    @GET("getWthrDataList?serviceKey=0ElkboaXwY1%2FJ2p4im01RxZ8Nh2%2Bt2E%2FQuim2Ebl0g9KNQsNy6i3YMq4xWjl1%2FmEqFEOOjHQvk5Nu0xZv5%2FJCg%3D%3D")

    suspend fun getWeather(
        @Query("pageNo") page_no: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("dataType") dataType: String,
        @Query("dataCd") dataCd: String,
        @Query("dateCd") dateCd: String,
        @Query("startDt") startDt: String,
        @Query("startHh") startHh: String,
        @Query("endDt") endDt: String,
        @Query("endHh") endHh: String,
        @Query("stnIds") stnIds: String,


//        @Query("numOfRows") num_of_rows: Int,   // 한 페이지 결과 수
//        @Query("pageNo") page_no: Int,          // 페이지 번호
//        @Query("dataType") data_type: String,   // 응답 자료 형식
//        @Query("base_date") base_date: String,  // 발표 일자
//        @Query("base_time") base_time: String,  // 발표 시각
//        @Query("nx") nx: Int,                // 예보지점 X 좌표
//        @Query("ny") ny: Int,                // 예보지점 Y 좌표
    ): WeatherApiResponse2

}