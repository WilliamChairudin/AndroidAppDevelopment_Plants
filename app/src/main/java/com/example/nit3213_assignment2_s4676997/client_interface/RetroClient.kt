package com.example.nit3213_assignment2_s4676997.client_interface

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Mark the class as a Dagger module
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides // Inform Hilt how to create and inject dependencies
    @Singleton //same instance will be used throughout the App

    //logs body request and responses of HTTP
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    //Builds the OkHttpClient instance with the provided logging interceptor
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    //Builds Retrofit instance with base URL and OKHttpClient
    //GsonConverterFactory to handle JSON serialization and deserialization
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://nit3213-api-h2b3-latest.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    //Provides implementation of AuthApi interface using RetroFit. API interface that handle HTTP request
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    //Provides implementation for PlantsApiService using Retrofit
    fun providePlantsApiServices(retrofit: Retrofit): PlantsApiService {
        return retrofit.create(PlantsApiService::class.java)
    }
}