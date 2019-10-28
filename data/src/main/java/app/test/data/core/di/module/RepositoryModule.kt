package app.test.data.core.di.module

import app.test.data.feature.animals.repository.AnimalsDataRepository
import app.test.domain.feature.animals.repository.AnimalsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindAnimalsDataRepository(repo: AnimalsDataRepository): AnimalsRepository
}