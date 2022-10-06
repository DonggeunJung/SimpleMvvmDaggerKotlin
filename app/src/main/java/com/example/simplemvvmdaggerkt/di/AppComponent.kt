package com.example.simplemvvmdaggerkt.di

import com.example.simplemvvmdaggerkt.viewmodel.UserViewModel
import com.example.simplemvvmdaggerkt.viewmodel.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun userViewModel(): UserViewModel
    fun viewModelFactory(): ViewModelFactory
}