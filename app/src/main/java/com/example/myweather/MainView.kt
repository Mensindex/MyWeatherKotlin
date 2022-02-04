package com.example.myweather

import com.example.myweather.global.MvpView

interface MainView: MvpView {

    fun showToastOnEmptyField()
    fun showToastOnFailure()
    fun setTemp(string: String)
}