package com.example.simplemvvmdaggerkt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemvvmdaggerkt.model.User
import com.example.simplemvvmdaggerkt.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserViewModel @Inject constructor(var userRepository: UserRepository) : ViewModel() {
    val userLiveData = MutableLiveData<User>()

    // Request Card data list to Repository
    fun reqUser() {
        viewModelScope.launch {
            val user = userRepository.reqUser()

            withContext(Dispatchers.Main) {
                user?.let { userLiveData.postValue(it) }
            }
        }
    }

}