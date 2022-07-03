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

    private val _list = MutableSharedFlow<List<WeatherApiResponse2.Response.Body.Items.Item?>?>()
    val list = _list.asSharedFlow()

    val listSortedByUUU = MutableSharedFlow<List<WeatherApiResponse2.Response.Body.Items.Item?>?>()

    private val service = RetrofitApi.serviceInterface

    fun updateList() {
        viewModelScope.launch {
            val response = service.getWeather(
                1,
                100,
                "JSON",
                "ASOS",
                "HR",
                "20100101",
                "01",
                "20100601",
                "01",
                "108"
            )

            val value = response.response?.body?.items?.item
            _list.emit(value)

            val sortedValue = response.response?.body?.items?.item

            listSortedByUUU.emit(sortedValue)
        }

    }
}