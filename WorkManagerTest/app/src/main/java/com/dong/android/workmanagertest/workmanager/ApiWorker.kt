package com.dong.android.workmanagertest.workmanager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.dong.android.workmanagertest.retrofit.RetrofitApi
import com.dong.android.workmanagertest.retrofit.WeatherApiResponse
import kotlinx.coroutines.flow.MutableSharedFlow

class ApiWorker(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {

    val dataAsFlow = MutableSharedFlow<List<WeatherApiResponse.Response.Body.Items.Item?>?>()

    override suspend fun doWork(): Result {
        getApi()
        return Result.success()
    }

    private suspend fun getApi() {
        Log.d("Worker", "Worker worked in ${Thread.currentThread().name}!")
        val service = RetrofitApi.serviceInterface
        val response = service.getWeather(
            10,
            1,
            "JSON",
            "20220716",
            "0500",
            55,
            127,
        )

        val value = response.response?.body?.items?.item
        dataAsFlow.emit(value)
        if (value != null) {
            for (i in value) {
                Log.d("Worker", i.toString())
            }
        }
    }
}