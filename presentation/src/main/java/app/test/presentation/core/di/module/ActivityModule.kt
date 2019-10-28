package app.test.presentation.core.di.module

import app.test.presentation.core.di.scope.ActivityScope
import app.test.presentation.feature.app.ui.AppActivity
import app.test.presentation.feature.detail.ui.AnimalDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun bindAppActivity(): AppActivity

    @ActivityScope
    @ContributesAndroidInjector
    fun bindAnimalDetailsActivity(): AnimalDetailsActivity
}