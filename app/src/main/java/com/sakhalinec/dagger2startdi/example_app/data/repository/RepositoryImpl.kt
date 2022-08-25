package com.sakhalinec.dagger2startdi.example_app.data.repository

import com.sakhalinec.dagger2startdi.example_app.data.datasource.LocalDataSource
import com.sakhalinec.dagger2startdi.example_app.data.datasource.RemoteDataSource
import com.sakhalinec.dagger2startdi.example_app.data.mapper.Mapper
import com.sakhalinec.dagger2startdi.example_app.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: Mapper
) : Repository {

    override fun method() {
        mapper.map()
        localDataSource.method()
        remoteDataSource.method()
    }
}