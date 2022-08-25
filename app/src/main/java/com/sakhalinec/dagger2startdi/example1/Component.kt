package com.sakhalinec.dagger2startdi.example1

class Component {

    // создание объекта Computer
    private fun getComputer(): Computer {
        val monitor = Monitor()
        val keyboard = Keyboard()
        val mouse = Mouse()
        val computerTower = ComputerTower(
            Storage(),
            Memory(),
            Processor()
        )

        return Computer(monitor, computerTower, keyboard, mouse)
    }

    // в качестве параметра принимает объект того класса куда будут вставляться данные
    fun inject(activity: Activity) {
        // обращаемся к полю объекта Activity и присваеваем метод создания объекта зависимости Computer
        activity.computer = getComputer()
        // либо создание объекта напрямую
        activity.keyboard = Keyboard()
    }

}