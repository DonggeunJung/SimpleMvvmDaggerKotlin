package com.example.simplemvvmdaggerkt.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {
    @get:GET("users/DonggeunJung")
    val user: Call<User>

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        // Create Retrofit object
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build()
    }
}