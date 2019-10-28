package app.test.presentation.feature.animals.dogs.vm

import app.test.domain.feature.animals.interactor.GetDogsUseCase
import app.test.domain.feature.animals.model.Animal
import app.test.presentation.feature.animals.base.vm.BaseAnimalsVm
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DogsVm @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase
) : BaseAnimalsVm() {

    override suspend fun loadAnimals(): Flow<List<Animal>> = getDogsUseCase()
}