package com.dong.android.hilttest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dong.android.hilttest.retrofit.RetrofitApi
import com.dong.android.hilttest.retrofit.RetrofitInterface
import com.dong.android.hilttest.retrofit.WeatherApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val retrofitInterface: RetrofitInterface,
) : ViewModel() {

    private val _list = MutableSharedFlow<List<WeatherApiResponse.Response.Body.Items.Item?>?>()
    val list = _list.asSharedFlow()

    fun updateList() {
        viewModelScope.launch {
            val response = retrofitInterface.getWeather(
                100,
                1,
                "JSON",
                "20220710",
                "0500",
                55,
                127
            )

            val value = response.response?.body?.items?.item
            _list.emit(value)
        }
    }
}