package com.sakhalinec.dagger2startdi.example2

import dagger.Component

// анотация @Component позволяет Dagger-у генерировать реализацию класса AppComponent
@Component(modules = [ComputerModule::class])
interface AppComponent {

    /*
        Component пердоставляет реализацию зависимостей или инжектит их в поля какого то класса
    */

    // первый способ получения зависимости при помощи Inject
    // метод который будет инжектиться в activity в поле с анотацией @Inject от туда дагер
    // получит информацию какой объект ему нужно создать, то есть сгенерировать и внедрить
    fun inject(activity: Activity)


    // второй способ получения зависимости при помощи get-ера
//    fun getKeyboard(): Keyboard
//    fun getMouse(): Mouse
//    fun getMonitor(): Monitor




}