package com.example.smarthomecontroll.api

import com.example.smarthomecontroll.models.DashboardResponse
import com.example.smarthomecontroll.models.LoginRequest
import com.example.smarthomecontroll.models.LoginResponse

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("{location}/auth") // Use a dynamic path for the location
    suspend fun login(
        @Path("location") location: String, // This will allow you to specify the location when calling the API
        @Body credentials: LoginRequest // The LoginRequest model for the body
    ): Response<LoginResponse>

    // Adding dashboard function to your existing ApiService
    @GET("dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<DashboardResponse>
}