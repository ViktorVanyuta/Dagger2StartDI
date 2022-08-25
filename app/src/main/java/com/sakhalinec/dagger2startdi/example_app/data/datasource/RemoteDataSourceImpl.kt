package com.sakhalinec.dagger2startdi.example_app.data.datasource

import com.sakhalinec.dagger2startdi.example_app.data.network.ApiService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override fun method() {
        apiService.method()
    }
}