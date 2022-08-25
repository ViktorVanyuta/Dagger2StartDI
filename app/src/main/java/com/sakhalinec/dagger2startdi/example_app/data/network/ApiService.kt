package com.sakhalinec.dagger2startdi.example_app.data.network

import android.content.Context
import android.util.Log
import com.sakhalinec.dagger2startdi.R
import com.sakhalinec.dagger2startdi.example_app.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Singleton

//@ApplicationScope навесил эту аннотацию в DataModule
class ApiService @Inject constructor(
    // пример передачи параметров в компонент билдер
    private val context: Context,
    private val timeMillis: Long
) {

    fun method() {
        Log.d(LOG_TAG, "ExampleApiService ${context.getString(R.string.app_name)} $timeMillis $this")
    }

    companion object {

        private const val LOG_TAG = "EXAMPLE_TEST"
    }

}