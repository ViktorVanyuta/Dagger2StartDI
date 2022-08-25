package com.sakhalinec.dagger2startdi.example_app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sakhalinec.dagger2startdi.example_app.di.IdQualifier
import com.sakhalinec.dagger2startdi.example_app.di.NameQualifier
import com.sakhalinec.dagger2startdi.example_app.domain.UseCase
import javax.inject.Inject
import javax.inject.Named

// стандартное создание view model-и которую будем получать через view model provider в
// классе ViewModelFactory
class ViewModel1 @Inject constructor(
    private val useCase: UseCase,
    private val id: String,
    //@Named("id") private val id: String,
    //@NameQualifier private val name: String
    //@Named("name") private val name: String
): ViewModel() {

    fun method() {
        useCase()
        Log.d("ViewModel", "$this $id ")
    }
}
