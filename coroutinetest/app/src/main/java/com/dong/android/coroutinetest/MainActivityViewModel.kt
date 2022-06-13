package com.dong.android.coroutinetest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val list = MutableLiveData<List<WeatherApiResponse.Response.Body.Items.Item?>?>()
    val listSortedByUUU = MutableLiveData<List<WeatherApiResponse.Response.Body.Items.Item?>?>()

    private val service = RetrofitApi.serviceInterface

    fun updateList() {
        viewModelScope.launch {
            val response = service.getWeather(
                100,
                1,
                "JSON",
                "20220613",
                "0500",
                55,
                127
            )

            list.value = response.body()?.response?.body?.items?.item
            listSortedByUUU.value = response.body()?.response?.body?.items?.item?.sortedBy {
                it?.category == "UUU"
            }
        }

    }
}