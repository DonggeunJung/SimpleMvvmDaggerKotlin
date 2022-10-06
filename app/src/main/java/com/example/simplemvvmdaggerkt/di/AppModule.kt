package com.example.simplemvvmdaggerkt.di

import com.example.simplemvvmdaggerkt.model.UserApi
import com.example.simplemvvmdaggerkt.model.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        // Create Retrofit API object & return
        return UserApi.retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi): UserRepository {
        return UserRepository(api)
    }

}