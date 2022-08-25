package com.sakhalinec.dagger2startdi.example_app.data.datasource

import com.sakhalinec.dagger2startdi.example_app.data.database.DataBase
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor (
    private val database: DataBase
) : LocalDataSource {

    override fun method() {
        database.method()
    }
}