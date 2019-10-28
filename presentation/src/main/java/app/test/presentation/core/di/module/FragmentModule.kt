package app.test.presentation.core.di.module

import app.test.presentation.core.di.scope.FragmentScope
import app.test.presentation.feature.animals.cats.ui.CatsFragment
import app.test.presentation.feature.animals.dogs.ui.DogsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun bindCatsFragment(): CatsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun bindDogsFragment(): DogsFragment
}