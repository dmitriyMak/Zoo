package app.test.data.core.di.module

import app.test.data.feature.animals.api.AnimalsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object ApiModule {

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AnimalsApi = retrofit.create(AnimalsApi::class.java)
}
