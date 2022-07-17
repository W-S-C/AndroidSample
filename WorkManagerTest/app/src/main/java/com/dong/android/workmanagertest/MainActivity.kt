package com.dong.android.workmanagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.work.WorkManager
import com.dong.android.workmanagertest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRetrofit()
        setBtnFunction()
    }

    private fun setBtnFunction() {
        binding.btn.setOnClickListener {
            viewModel.getList()
        }
    }

    private fun setRetrofit() {
        viewModel.startOneTimeWorkManager(WorkManager.getInstance(applicationContext))

        lifecycleScope.launchWhenStarted {
            viewModel.list.collect { list ->
                list?.forEach { it ->
                    Log.d("Whole List", it.toString())
                }
                if (list == null) {
                    Log.d("Whole List", "null null null")
                }
            }
        }
    }
}