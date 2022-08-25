package com.sakhalinec.dagger2startdi.example_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sakhalinec.dagger2startdi.example_app.di.ApplicationScope
import com.sakhalinec.dagger2startdi.example_app.domain.Repository
import com.sakhalinec.dagger2startdi.example_app.domain.UseCase
import javax.inject.Inject
import javax.inject.Provider

// в конструктор прилетает коллекция Map в которой будут лежать по значению provider view model-ей
// и по ключу класс соответствующей view model-и
// чтобы получить данную коллекцию необходим отдельный модуль в данном случае ViewModelModule
// так же чтобы Dagger мог вернуть параметризованную коллекцию необходимо указать @JvmSuppressWildcards
// ТУТ ПРИ КАЖДОМ ВЫЗОВЕ ФУНКЦИИ БУДЕТ КАЖДЫЙ РАЗ СОЗДАВАТЬСЯ НОВАЯ VIEW MODEL,
// пока живет экран живет и view model, умрет экран умрет и view model, создан экран создана и VM

class ViewModelFactory @Inject constructor(
    private val viewModelProviders: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
): ViewModelProvider.Factory {

    // когда где то понадобится view model будет вызвана эта функция которая по соответствующему
    // ключу ([modelClass.simpleName]) получит view model и приведет ее к нужному типу
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModelProviders[modelClass]?.get() as T
    }
}



/*
// В ЭТОМ ВАРИАНТЕ СРАЗУ СОЗДАЮТСЯ ВСЕ VIEW MODEL-И ДЛЯ ВСЕХ ЭКРАНОВ
// в конструктор прилетает коллекция Map в которой будут лежать по значению view model-и
// и по ключу String будет лежать имя соответствующей view model-и
// чтобы получить данную коллекцию необходим отдельный модуль в данном случае ViewModelModule
// так же чтобы Dagger мог вернуть параметризованную коллекцию необходимо указать @JvmSuppressWildcards
class ViewModelFactory @Inject constructor(
    private val viewModels: @JvmSuppressWildcards Map<String, ViewModel>
): ViewModelProvider.Factory {

    // когда где то понадобится view model будет вызвана эта функция которая по соответствующему
    // ключу ([modelClass.simpleName]) получит view model и приведет ее к нужному типу
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModels[modelClass.simpleName] as T
    }
}*/



// данный способ применим только с небольшим количеством view model-ей и малым количеством
// параметров в конструкторе потому, что если будет много view model-ей на каждую из них
// придется делать ручками проверку и в конструктор передавать параметры каждой view model-и
// и тут получается мы сами ручками создаем view model-и и передаем все параметры,
// а это все должен делать Dagger за нас
/*
class ViewModelFactory @Inject constructor(
    private val useCase: UseCase,
    private val repository: Repository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == ViewModel1::class.java) {
            return ViewModel1(useCase = useCase) as T
        }
        if (modelClass == ViewModel2::class.java) {
            return ViewModel2(repository = repository) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")
    }
}*/
