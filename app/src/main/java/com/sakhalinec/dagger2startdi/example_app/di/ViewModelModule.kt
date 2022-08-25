package com.sakhalinec.dagger2startdi.example_app.di

import androidx.lifecycle.ViewModel
import com.sakhalinec.dagger2startdi.example_app.ui.ViewModel1
import com.sakhalinec.dagger2startdi.example_app.ui.ViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap
import dagger.multibindings.LongKey
import dagger.multibindings.StringKey

// модуль для заполнения коллекции Map в конструкторе фабрики view model-ей
@Module
interface ViewModelModule {

/*
    ТАКОЙ СПОСОБ ПОДХОДИТ ТОЛЬКО ДЛЯ ДЕБАЖНОЙ СБОРКИ
    @IntoMap // данная аннотация говорит Dagger-у возьми все помеченные аннотацией view model-и
    // и помести их в коллекцию, которую мы получаем в конструкторе ViewModelFactory
    @StringKey("ViewModel1") // этой аннотацией указывается по какому ключу будет
    // лежать view model в коллекции. Есть еще аннотации @LongKey @IntKey для соответствующих типов
    @Binds
    fun bindViewModel1(impl: ViewModel1): ViewModel // возвращать нужно родительский класс
*/


    @IntoMap
    // для релизной сборки вместо @StringKey нужно использовать свою аннотацию и передавать сам класс
    @ViewModelKey(ViewModel1::class)
    @Binds
    fun bindViewModel1(impl: ViewModel1): ViewModel

    @IntoMap
    @ViewModelKey(ViewModel2::class)
    @Binds
    fun bindViewModel2(impl: ViewModel2): ViewModel

}