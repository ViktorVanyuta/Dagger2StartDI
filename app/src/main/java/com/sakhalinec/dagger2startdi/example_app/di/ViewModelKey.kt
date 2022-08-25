package com.sakhalinec.dagger2startdi.example_app.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/*
    Созданная аннотация по сути является ключем для коллекции Map которуя используется в
    конструкторе ViewModelFactory
    KClass так как Dagger использует Java классы мы не можем использовать просто Class<> нужно
    использовать Kotlin обертку KClass<>
*/

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
