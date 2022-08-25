package com.sakhalinec.dagger2startdi.example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sakhalinec.dagger2startdi.R
import com.sakhalinec.dagger2startdi.example2.Activity
import javax.inject.Inject

class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // для проверки работоспособности приложения
        val activity = Activity()
        activity.keyboard.toString()
        activity.mouse.toString()
        activity.monitor.toString()
        activity.computer.toString()

    }
}