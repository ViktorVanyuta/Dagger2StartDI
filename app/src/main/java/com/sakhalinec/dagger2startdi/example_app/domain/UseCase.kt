package com.sakhalinec.dagger2startdi.example_app.domain

import javax.inject.Inject

class UseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() {
        repository.method()
    }
}