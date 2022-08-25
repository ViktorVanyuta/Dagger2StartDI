package com.sakhalinec.dagger2startdi.example_app.di

import javax.inject.Scope

// своя кастомная реализация аннотации для определения скоупа
// данную аннотацию так же можно навесить на @Binds и @Provides функции когда у нас нет
// возможности пометить аннотацией какой то класс

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope
