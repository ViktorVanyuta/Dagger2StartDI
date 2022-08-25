package com.sakhalinec.dagger2startdi.example2

import javax.inject.Inject

class Computer (
    // доставка объектов в конструктор, для того чтобы не создавать зависимости в классе
    val monitor: Monitor,
    val computerTower: ComputerTower,
    val keyboard: Keyboard,
    val mouse: Mouse
)
