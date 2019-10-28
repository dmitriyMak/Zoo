package app.test.data.core.di.module

import app.test.data.core.di.qualifires.Interceptors
import app.test.data.core.di.qualifires.ServerUrl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [InterceptorModule::class])
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun converterFactory(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    fun provideOkHttpClient(
        @Interceptors interceptors: List<Interceptor>
    ): OkHttpClient =
        OkHttpClient().newBuilder()
            .apply { interceptors.forEach { addInterceptor(it) } }
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        @ServerUrl baseUrl: String
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
}