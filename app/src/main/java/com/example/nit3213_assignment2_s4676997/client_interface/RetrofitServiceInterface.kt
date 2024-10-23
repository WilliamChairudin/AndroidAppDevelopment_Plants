package com.example.nit3213_assignment2_s4676997.client_interface

import retrofit2.Call
import retrofit2.http.GET //GET request
import retrofit2.http.POST //POST request
import retrofit2.http.Body //Retrieve information from Body from POST request
import com.example.nit3213_assignment2_s4676997.data.LoginRequest
import com.example.nit3213_assignment2_s4676997.data.PlantResponse

//Authentication Details
interface AuthApi {
    @POST("footscray/auth")
    fun login(@Body loginRequest: LoginRequest): Call<Void>
}

//Plants Details
interface PlantsApiService {
    @GET("/dashboard/plants")
    fun getPlants(): Call<PlantResponse>
}