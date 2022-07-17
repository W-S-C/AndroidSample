package com.dong.android.workmanagertest.workmanager

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.dong.android.workmanagertest.retrofit.RetrofitApi
import com.dong.android.workmanagertest.retrofit.WeatherItem
import com.dong.android.workmanagertest.room.ItemDao
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
class ApiWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val itemDao: ItemDao,
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        getApi()
        return Result.success()
    }

    private suspend fun getApi() {
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

        itemDao.deleteAll()

        if (value != null) {
            for (i in value) {
                Log.d("Worker", i.toString())
                if (i != null) {
                    val dbValue = WeatherItem(
                        id = 0,
                        i.baseDate,
                        i.baseTime,
                        i.category,
                        i.fcstDate,
                        i.fcstTime,
                        i.fcstValue,
                        i.nx,
                        i.ny
                    )

                    itemDao.insertList(dbValue)
                }
            }
        }
    }
}