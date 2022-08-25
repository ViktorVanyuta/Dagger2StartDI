package com.sakhalinec.dagger2startdi.example_app.di


import android.content.Context
import dagger.BindsInstance
import dagger.Component

// анотация @Singleton говорит о том что компонент будет один на все приложение, а так же
// @Singleton у компонента определяет скоуп в рамках которого будет жить один экземпляр данного класса
// @Singleton в место Singleton лучше использовать CustomScope потому что по аннотации
// синглтон не понятно в рамках какого скоупа работает помеченный класс
// @ApplicationScope определяет в рамках какого скоупа будет жить компонент, этот компонент
// будет жить все время жизни приложения
@ApplicationScope
// тут необходимо перечислить модули
@Component(modules = [DataModule::class, DomainModule::class])
interface ApplicationComponent {

    // функция создания @Subcomponent-a возвращая фабрику сабкомпонента
    fun activityComponentFactory(): ActivityComponent.Factory

    // создание своего component factory особой разницы от builder нет
    @Component.Factory
    interface ApplicationComponentFactory {

        // просто возвращает экземпляр основного компонента дагера и принимает на вход
        // параметры то есть зависимости которые необходимо передать
        fun create(
            @BindsInstance context: Context,
            @BindsInstance timeMillis: Long
        ): ApplicationComponent

    }

    /*
    // создание своего компонент билдера
    @Component.Builder
    interface ApplicationComponentBuilder {

        // функция возвращает экземпляр кастомного компонента у которого будет вызвана
        // функция build() и будет возвращен основной компонент
        @BindsInstance //говорим дагеру что нужно (context: Context) вставить в граф зависимостей
        fun context(context: Context): ApplicationComponentBuilder

        @BindsInstance
        fun timeMillis(timeMillis: Long): ApplicationComponentBuilder

        // просто возвращает экземпляр основного компонента дагера
        fun build(): ApplicationComponent

    }
    */

}