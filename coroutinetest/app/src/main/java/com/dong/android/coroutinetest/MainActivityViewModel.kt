package com.dong.android.coroutinetest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _list = MutableSharedFlow<List<WeatherApiResponse.Response.Body.Items.Item?>?>()
    val list = _list.asSharedFlow()

    val listSortedByUUU = MutableLiveData<List<WeatherApiResponse.Response.Body.Items.Item?>?>()

    private val service = RetrofitApi.serviceInterface

    fun updateList() {
        viewModelScope.launch {
            val response = service.getWeather(
                100,
                1,
                "JSON",
                "20220702",
                "0500",
                55,
                127
            )

            val value = response.body()?.response?.body?.items?.item
            _list.emit(value)

            listSortedByUUU.value = response.body()?.response?.body?.items?.item?.sortedBy {
                it?.category == "UUU"
            }
        }

    }
}