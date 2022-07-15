package com.dong.android.workmanagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRetrofit()
    }

    private fun setRetrofit() {
        viewModel.updateList()

        lifecycleScope.launchWhenStarted {
            viewModel.list.collect { list ->
                list?.forEach { it ->
                    Log.d("Whole List", it.toString())
                }
            }
        }
    }
}