package com.sakhalinec.dagger2startdi.example_app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sakhalinec.dagger2startdi.example_app.domain.Repository
import com.sakhalinec.dagger2startdi.example_app.domain.UseCase
import javax.inject.Inject

class ViewModel2 @Inject constructor(
    private val repository: Repository,
    private val id: String
): ViewModel() {

    fun method() {
        repository.method()
        Log.d("ViewModel2", "$this $id")
    }
}
