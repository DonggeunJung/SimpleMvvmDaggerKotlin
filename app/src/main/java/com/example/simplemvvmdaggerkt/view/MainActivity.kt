package com.example.simplemvvmdaggerkt.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.simplemvvmdaggerkt.R
import com.example.simplemvvmdaggerkt.databinding.ActivityMainBinding
import com.example.simplemvvmdaggerkt.viewmodel.UserViewModel

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : UserViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        observeLiveData()
        viewModel.reqUser()
    }

    private fun observeLiveData() {
        viewModel.userLiveData.observe(this) {
            binding.user = it
        }
    }
}