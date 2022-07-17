package com.dong.android.workmanagertest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.dong.android.workmanagertest.retrofit.WeatherApiResponse
import com.dong.android.workmanagertest.room.ItemDao
import com.dong.android.workmanagertest.workmanager.ApiWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val itemDao: ItemDao,
) : ViewModel() {

    private val _list = MutableSharedFlow<List<WeatherApiResponse.Response.Body.Items.Item?>?>()
    val list = _list.asSharedFlow()

    fun startOneTimeWorkManager(workManager: WorkManager) {
        val workRequest = OneTimeWorkRequestBuilder<ApiWorker>().build()
        workManager.enqueue(workRequest)
    }

    fun getList() {
        viewModelScope.launch {
            val apiList = mutableListOf<WeatherApiResponse.Response.Body.Items.Item>()
            itemDao.getAll()?.forEach {
                apiList.add(
                    WeatherApiResponse.Response.Body.Items.Item(
                        it.baseDate,
                        it.baseTime,
                        it.category,
                        it.fcstDate,
                        it.fcstTime,
                        it.fcstValue,
                        it.nx,
                        it.ny
                    )
                )
            }
            _list.emit(apiList)
        }
    }
}