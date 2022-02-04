package com.example.myweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), MainView {
    private var userField: EditText? = null
    private var mainButton: Button? = null
    private var resultInfo: TextView? = null
    private var progress: ProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val presenter = MainPresenter()
        //Не забывай! передавать презентеру в интерфейс View-класс,
        // т.к. он общается только с интерфейсом
        presenter.attachView(this)
        userField = findViewById(R.id.userField)
        mainButton = findViewById(R.id.main_button)
        resultInfo = findViewById((R.id.result_info))
        progress = findViewById(R.id.progress)

        mainButton?.setOnClickListener {
            presenter.getResult(userField?.text.toString())
            Toast.makeText(this, "Кнопка сработала", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showToastOnEmptyField() {
        Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
    }

    override fun showToastOnFailure() {
        Toast.makeText(this, "Не пришел ответ с сервера", Toast.LENGTH_SHORT).show()
    }

    override fun setTemp(string: String) {
        resultInfo?.text = string
    }

    //Функции в котлин не могут быть с пустым телом, поэтому пишем "= Unit"
    override fun showProgress(){
        progress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress?.visibility = View.GONE
    }
}