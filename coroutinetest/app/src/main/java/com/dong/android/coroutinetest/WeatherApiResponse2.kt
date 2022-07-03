package com.dong.android.coroutinetest

data class WeatherApiResponse2(
    val response: Response?
) {
    data class Response(
        val body: Body?,
        val header: Header?
    ) {
        data class Body(
            val dataType: String?,
            val items: Items?,
            val numOfRows: Int?,
            val pageNo: Int?,
            val totalCount: Int?
        ) {
            data class Items(
                val item: List<Item?>?
            ) {
                data class Item(
                    val clfmAbbrCd: String?,
                    val dc10LmcsCa: String?,
                    val dc10Tca: String?,
                    val dmstMtphNo: String?,
                    val dsnw: String?,
                    val gndSttCd: String?,
                    val hm: String?,
                    val hmQcflg: String?,
                    val hr3Fhsc: String?,
                    val icsr: String?,
                    val lcsCh: String?,
                    val m005Te: String?,
                    val m01Te: String?,
                    val m02Te: String?,
                    val m03Te: String?,
                    val pa: String?,
                    val paQcflg: String?,
                    val ps: String?,
                    val psQcflg: String?,
                    val pv: String?,
                    val rn: String?,
                    val rnQcflg: String?,
                    val rnum: String?,
                    val ss: String?,
                    val ssQcflg: String?,
                    val stnId: String?,
                    val stnNm: String?,
                    val ta: String?,
                    val taQcflg: String?,
                    val td: String?,
                    val tm: String?,
                    val ts: String?,
                    val tsQcflg: String?,
                    val vs: String?,
                    val wd: String?,
                    val wdQcflg: String?,
                    val ws: String?,
                    val wsQcflg: String?
                )
            }
        }

        data class Header(
            val resultCode: String?,
            val resultMsg: String?
        )
    }
}