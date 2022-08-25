package com.sakhalinec.dagger2startdi.example_app.di

import com.sakhalinec.dagger2startdi.example_app.ui.MainActivity1
import com.sakhalinec.dagger2startdi.example_app.ui.MainActivity2
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

/*
    Отличие @Subcomponent от @Component в том что Component мы можем создавать сами через фабрику
    используя функцию create() то, Subcomponent мы создать сами не можем.

    Subcomponent умеет создавать только компонент в котором он находится то есть в (ApplicationComponent-е)
    нужно создать функцию которая вернет фабрику @Subcomponent-а (ActivityComponent)

    Subcomponent так же можно воспринимать как наследника от Component-а так как если Subcomponent
    не может самостоятельно предоставить какую то зависимость он может взять ее у родителя Component
    но не наоборот, Component не может брать зависимости у Subcomponent-а
*/

@Subcomponent(modules = [ViewModelModule::class])// создает view model-и поэтому подключаем модуль
interface ActivityComponent {

    // функция куда будут внедряться зависимости
    fun inject(mainActivity1: MainActivity1)
    fun inject(mainActivity2: MainActivity2)

    @Subcomponent.Factory
    interface Factory {

        fun create(
            // передаем id во view model-и которые дальше улетают в активити
            @BindsInstance  id: String
            // @BindsInstance @IdQualifier id: String,

            // если оставить передачу параметров так то, будет ошибка! потому что Dagger не смотрит
            // на название переменной ему важен только тип который будет класть в граф зависимостей
            // и где нужен будет этот тип он его будет передавать, тут он не знает какой из типов
            // положить в граф чтобы потом его отдать. Чтобы этого избежать нужно использовать
            // аннотацию @Named(указать имя переменной) или использовать Qualifiers
            // @BindsInstance name: String

            //@BindsInstance @Named("Name") name: String
            // @BindsInstance @NameQualifier name: String
        ): ActivityComponent

    }

}