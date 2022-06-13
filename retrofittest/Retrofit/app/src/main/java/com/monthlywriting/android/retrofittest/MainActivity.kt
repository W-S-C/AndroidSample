package com.monthlywriting.android.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.monthlywriting.android.retrofittest.model.ApiDataResponse
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        setRetrofit()
    }

    private fun setRecyclerView() {

    }

    private fun setRetrofit() {
        val service = RetrofitApi.serviceInterface

        val call = service.getWeather(
            100,
            1,
            "JSON",
            "20220609",
            "0500",
            55,
            127
        )

        call.enqueue(object : retrofit2.Callback<ApiDataResponse> {
            override fun onResponse(
                call: Call<ApiDataResponse>,
                response: Response<ApiDataResponse>,
            ) {
                if (response.isSuccessful) {
                    val apiDataResponse = response.body()!!
                    val itemList = apiDataResponse.response?.body?.items?.item

                    itemList?.forEach {
                        Log.d("Item List", it.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ApiDataResponse>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
    }
}