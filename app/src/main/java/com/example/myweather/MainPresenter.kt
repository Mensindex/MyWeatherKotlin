package com.example.myweather

import android.util.Log
import com.example.myweather.global.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : MvpPresenter<MainView>() {

    private companion object {
        const val KEY = "7e020573198c66cad1738a6b21b5fd69"
        const val UNITS = "metric"
    }


    fun getResult(city: String) {
        view?.showProgress()
        if (city.trim().isBlank()) {
            view?.hideProgress()
            view?.showToastOnEmptyField()
        } else {
            MyApplication
                .apiService
                .getWeather(city, KEY, UNITS)
                .enqueue(object : Callback<Model> {
                    override fun onResponse(call: Call<Model>, response: Response<Model>) {
                        view?.hideProgress()
                        view?.setTemp(response.body()?.main?.temp.toString())
                    }

                    override fun onFailure(call: Call<Model>, t: Throwable) {
                        Log.d("ОШИБКА", t.message!!)
                        view?.showToastOnFailure()
                    }

                })
        }
    }
}