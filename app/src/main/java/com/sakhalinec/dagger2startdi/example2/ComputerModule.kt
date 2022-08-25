package com.sakhalinec.dagger2startdi.example2

import dagger.Module
import dagger.Provides

@Module
class ComputerModule {

    /*
        Module позволяет предоставлять реализацию интерфейсов или классов если на них нельзя
        навесить анотацию @Inject
    */


    // после того как Dagger пройдет по всем зависимостям и не увидит Inject он
    // будет смотреть в Module
    // сами делаем реализацию создания нужного объекта в данном случае Monitor и предоставляем зависимость
    @Provides
    fun provideMonitor(): Monitor {
        return Monitor()
    }

    @Provides
    fun provideComputerTower(
        memory: Memory,
        processor: Processor,
        storage: Storage
    ): ComputerTower {
        return ComputerTower(memory = memory, processor = processor, storage = storage)
    }

    @Provides
    fun provideKeyboard(): Keyboard {
        return Keyboard()
    }

    @Provides
    fun provideMouse(): Mouse {
        return Mouse()
    }

    // если для создания какого то объекта так же нужны зависимости и при этом Dagger знает
    // как их создавать то, их можно передавать в качестве параметров в метод и использовать
    // внутри метода передать в качестве параметра в конструктор
    @Provides
    fun provideComputer(
        monitor: Monitor,
        computerTower: ComputerTower,
        keyboard: Keyboard,
        mouse: Mouse
    ): Computer {
        return Computer(
            monitor = monitor,
            computerTower = computerTower,
            keyboard = keyboard,
            mouse = mouse
        )
    }


}