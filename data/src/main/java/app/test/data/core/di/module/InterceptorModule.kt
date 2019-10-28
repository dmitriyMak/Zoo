package app.test.data.core.di.module

import app.test.data.core.di.qualifires.Interceptors
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
object InterceptorModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    @Interceptors
    fun provideInterceptors(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): List<@JvmWildcard Interceptor> =
        listOf(httpLoggingInterceptor)
}