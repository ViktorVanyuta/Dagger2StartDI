package com.sakhalinec.dagger2startdi.example_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sakhalinec.dagger2startdi.R
import com.sakhalinec.dagger2startdi.example_app.ApplicationExample

import javax.inject.Inject

class MainActivity1 : AppCompatActivity() {

    // доступа к конструктору Activity нету и нельзя заинжектить ничего в конструктор
    // поэтому инжектить можно в поле
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel1 by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModel1::class.java]
    }

    private val viewModel2 by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModel2::class.java]
    }


    // получаем ссылку на приложение через application и приводим его к нашему
    // типу ApplicationExample и таким образом можно обращаться к компоненту
    private val component by lazy {
        (application as ApplicationExample).component
            .activityComponentFactory()
            .create("MY_ACTIVITY_ID_1")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        // инжект лучше делать до вызова super.onCreate() для того чтобы точно были
        // проинициализированы все поля когда активити будет создана
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel1.method()

        // для примера с созданием view model-ей запуск второй активити
        findViewById<TextView>(R.id.tv_hello_world).setOnClickListener{
            Intent(this, MainActivity2::class.java).apply {
                startActivity(this)
            }
        }


    }
}