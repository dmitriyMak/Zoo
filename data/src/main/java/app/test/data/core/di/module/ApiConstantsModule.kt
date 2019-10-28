package app.test.data.core.di.module

import app.test.data.core.di.qualifires.ServerUrl
import dagger.Module
import dagger.Provides

@Module
object ApiConstantsModule {

    @Provides
    @ServerUrl
    fun provideServerUrl(): String = "http://kot3.com/"
}