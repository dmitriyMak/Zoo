package app.test.presentation.feature.detail.vm

import androidx.lifecycle.MutableLiveData
import app.test.domain.feature.animals.model.Animal
import app.test.presentation.core.vm.BaseVm
import javax.inject.Inject

class AnimalDetailsVm @Inject constructor() : BaseVm() {

    val animalLD = MutableLiveData<Animal>()

    fun setAnimal(animal: Animal) {
        animalLD.value = animal
    }
}