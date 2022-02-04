package com.example.myweather.global

abstract class MvpPresenter<Type : MvpView?> {
    var view: Type? = null
        private set

    fun attachView(type: Type) {
        view = type
    }
}