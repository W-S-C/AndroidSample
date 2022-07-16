package com.dong.android.workmanagertest

import androidx.lifecycle.ViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.dong.android.workmanagertest.workmanager.ApiWorker

class MainActivityViewModel : ViewModel() {

    fun startOneTimeWorkManager(workManager: WorkManager) {
        val workRequest = OneTimeWorkRequestBuilder<ApiWorker>().build()
        workManager.enqueue(workRequest)
    }
}