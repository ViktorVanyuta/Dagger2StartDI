package com.sakhalinec.dagger2startdi.example_app

import android.app.Application
import com.sakhalinec.dagger2startdi.example_app.di.DaggerApplicationComponent

class ApplicationExample: Application() {


    // инициализация Dagger компонента через функцию create() у factory отличия от builder
    // только в передачи зависимостей, тут просто их перечисляем в параметрах функции create()
    // а в builder-e под каждую зависимость делается отделаная функция
    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(context = this, System.currentTimeMillis())
    }


    /*
   // инициализация Dagger компонента в случае если у каких то модулей есть параметры в
   // конструкторе то нужно инициализировать при помощи Custom Builder
   private val component by lazy {
       DaggerApplicationComponent.builder()
           //.contextModule(ContextModule(application))
           .context(application)
           .timeMillis(System.currentTimeMillis())
           .build()
   }
   */


}