package com.sakhalinec.dagger2startdi.example_app.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

// ДЛЯ ПРИМЕРА, ОДИН ИЗ СПОСОБОВ ВЗАИМОДЕЙСТВИЯ МОДУЛЯ С ПАРАМЕТРАМИ, НО ЛУЧШЕ
// ИСПОЛЬЗОВАТЬ Custom Builder c анотацией @BindsInstance

@Module // в компоненте специально не перечислен, так как нужен только для примера
class ContextModule(private val application: Application) {

    /*
        Чтобы не было утечек памяти желательно передавать контекст приложения, а не
        контекст активити. Конкретно тут разницы нет так как контекст будет создан в активити
        и соответственно там же и будет убит.
    */

    @Provides
    fun provideContext(): Context {
        return application
    }

}