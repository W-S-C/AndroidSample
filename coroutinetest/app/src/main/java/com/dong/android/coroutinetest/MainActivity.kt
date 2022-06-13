package com.dong.android.coroutinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRetrofit()
    }

    private fun setRetrofit() {
        viewModel.updateList()
        viewModel.dataList.observe(this) { list ->
            list?.forEach { it ->
                Log.d("Item List", it.toString())
            }
        }
    }
}