package app.test.data.core.di.module

import app.test.data.core.di.qualifires.Remote
import app.test.data.feature.animals.datasource.AnimalsDataSource
import app.test.data.feature.animals.datasource.AnimalsRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataSourceModule {

    @Binds
    @Remote
    @Singleton
    fun bindAnimalsRemoteDataSource(source: AnimalsRemoteDataSource): AnimalsDataSource
}