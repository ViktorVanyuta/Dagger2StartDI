package com.sakhalinec.dagger2startdi.example2

import javax.inject.Inject

class ComputerTower (
    // доставка объектов в конструктор, для того чтобы не создавать зависимости в классе
    val storage: Storage,
    val memory: Memory,
    val processor: Processor
)
