package com.sakhalinec.dagger2startdi.example_app.di

import com.sakhalinec.dagger2startdi.example_app.data.datasource.*
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @ApplicationScope
    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

}