package com.example.simplemvvmdaggerkt.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserRepository(var api: UserApi) {

    suspend fun reqUser(): User? {
        val call: Call<User> = api.user
        return suspendCoroutine { continuation ->
            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    continuation.resume(response.body())
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    continuation.resume(null)
                }
            })
        }
    }

}