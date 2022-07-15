package com.dong.android.workmanagertest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _list = MutableSharedFlow<List<WeatherApiResponse.Response.Body.Items.Item?>?>()
    val list = _list.asSharedFlow()

    private val service = RetrofitApi.serviceInterface

    fun updateList() {
        viewModelScope.launch {
            val response = service.getWeather(
                10,
                1,
                "JSON",
                "20220715",
                "0500",
                55,
                127,
            )

            val value = response.response?.body?.items?.item
            _list.emit(value)
        }

    }
}