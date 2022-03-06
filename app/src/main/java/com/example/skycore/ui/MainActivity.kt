package com.example.skycore.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.skycore.*
import com.example.skycore.databinding.ActivityMainBinding
import com.example.skycore.sync.RetrofitService
import com.example.skycore.utils.MainAdapter
import com.example.skycore.utils.MainRepository

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
        binding.recyclerview.adapter = adapter
        viewModel.restaurantList.observe(this, {
            adapter.setRestaurantList(it)
        })
        viewModel.errorMessage.observe(this, {
            Log.e(TAG, "onCreate.errorMessage: $it")
        })
        viewModel.getAllRestaurants()
    }

}