package com.sakhalinec.dagger2startdi.example2

import javax.inject.Inject

// просто для примера, проецируем типа эта реальная активити с экраном
class Activity {

    /*

    */

    // создание Dagger компонента, для удобства
    private val component: AppComponent = DaggerAppComponent.create()

    // иньекция зависимости в поле
    // поле переменной обязательно должно быть публичным, чтобы Dagger имел к ней доступ
    @Inject
    lateinit var keyboard: Keyboard
    @Inject
    lateinit var mouse: Mouse
    @Inject
    lateinit var monitor: Monitor
    @Inject
    lateinit var computer: Computer

    init {
       component.inject(this)
    }



    // еще один способ внедрить зависимость при помощи get-era
//    val keyboard: Keyboard = component.getKeyboard()
//    val mouse: Mouse = component.getMouse()
//    val monitor: Monitor = component.getMonitor()





}

