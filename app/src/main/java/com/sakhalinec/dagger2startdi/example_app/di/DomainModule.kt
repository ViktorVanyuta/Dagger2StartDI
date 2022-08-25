package com.sakhalinec.dagger2startdi.example_app.di

import com.sakhalinec.dagger2startdi.example_app.data.repository.RepositoryImpl
import com.sakhalinec.dagger2startdi.example_app.domain.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    /*
        Для примера оставил класс абстрактным, потому что тут могут быть и функции
        с анотацией @Provides
        Если тут будут только фунции без реализации то, никто не мешает сделать Interface
    */

    // когда нужно заинжектить интерфейс
    // поскольку Dagger знает как создавать RepositoryImpl нам не нужно перечеслять в параметрах
    // необходимые зависимости, а можем в параметры передать реализацию интерфейса и вернуть его
//    @Provides
//    fun provideRepository(impl: RepositoryImpl): Repository {
//        return impl
//    }

    /*
        Если нужно предоставить реализацию интерфейса то предпочтительнее использовать @Binds
        поскольку в случае с использованием @Provides Dagger будет создавать экземпляр модуля
        и будет вызывать созданные в нем функции, а в случае с использованием @Binds функция
        вызвана не будет и если в классе все функции помечены как @Binds то Dagger не будет
        даже создавать екземпляр этого класса он просто посмотрит что для такого то интерфейса
        нужна такая то реализация
    */

    // эта функция связывает интерфейс с реализацией
    @Binds
    abstract fun bindRepository(impl: RepositoryImpl): Repository
}