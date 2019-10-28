package app.test.presentation.core.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.test.presentation.core.vm.factory.ViewModelFactory
import app.test.presentation.core.vm.factory.VmKey
import app.test.presentation.feature.animals.cats.vm.CatsVm
import app.test.presentation.feature.animals.dogs.vm.DogsVm
import app.test.presentation.feature.app.vm.AppVm
import app.test.presentation.feature.detail.vm.AnimalDetailsVm
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface VmModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @VmKey(AppVm::class)
    fun bindAppVm(vm: AppVm): ViewModel

    @Binds
    @IntoMap
    @VmKey(CatsVm::class)
    fun bindCatsVm(vm: CatsVm): ViewModel

    @Binds
    @IntoMap
    @VmKey(DogsVm::class)
    fun bindDogsVm(vm: DogsVm): ViewModel

    @Binds
    @IntoMap
    @VmKey(AnimalDetailsVm::class)
    fun bindAnimalDetailsVm(vm: AnimalDetailsVm): ViewModel
}