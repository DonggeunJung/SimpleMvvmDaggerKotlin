package com.example.simplemvvmdaggerkt.view

import androidx.appcompat.app.AppCompatActivity
import com.example.simplemvvmdaggerkt.di.DaggerAppComponent

open class BaseActivity : AppCompatActivity() {

    protected val viewModelFactory = DaggerAppComponent.builder().build().viewModelFactory()

}