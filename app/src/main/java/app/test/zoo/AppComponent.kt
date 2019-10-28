package app.test.zoo

import app.test.data.core.di.module.*
import app.test.presentation.core.di.module.ActivityModule
import app.test.presentation.core.di.module.FragmentModule
import app.test.presentation.core.di.module.VmModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        VmModule::class,
        RepositoryModule::class,
        DataMappersModule::class,
        DataSourceModule::class,
        ApiModule::class,
        ApiConstantsModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}