package com.dong.android.coroutinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect

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

        viewModel.listSortedByUUU.observe(this) { list ->
            list?.forEach { it ->
                Log.d("Sorted List", it.toString())
            }
        }
    }
}