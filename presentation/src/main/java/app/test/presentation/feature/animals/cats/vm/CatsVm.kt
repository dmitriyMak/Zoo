package app.test.presentation.feature.animals.cats.vm

import app.test.domain.feature.animals.interactor.GetCatsUseCase
import app.test.domain.feature.animals.model.Animal
import app.test.presentation.feature.animals.base.vm.BaseAnimalsVm
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatsVm @Inject constructor(
    private val getCatsUseCase: GetCatsUseCase
) : BaseAnimalsVm() {

    override suspend fun loadAnimals(): Flow<List<Animal>> = getCatsUseCase()
}