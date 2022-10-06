package com.example.simplemvvmdaggerkt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(userViewModelProdiver: Provider<UserViewModel>): ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        UserViewModel::class.java to userViewModelProdiver
    )

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(providers.contains(modelClass)) {
            return providers[modelClass]!!.get() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: \${modelClass.name}")
    }
}