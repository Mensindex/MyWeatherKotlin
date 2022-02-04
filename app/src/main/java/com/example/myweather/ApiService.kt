package com.example.myweather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") key: String,
        @Query("units") unit: String
        //@Query("units") metric: String
    ): Call<Model>
}