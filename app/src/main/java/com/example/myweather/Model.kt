package com.example.myweather

import com.google.gson.annotations.SerializedName

data class Model(
    val main: Main
    ) {
    data class Main(val temp: Double
    )
}
