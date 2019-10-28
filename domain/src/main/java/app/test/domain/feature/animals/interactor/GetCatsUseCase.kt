package app.test.domain.feature.animals.interactor

import app.test.domain.core.interactor.SingleListUseCase
import app.test.domain.feature.animals.model.Animal
import app.test.domain.feature.animals.repository.AnimalsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(
    private val repository: AnimalsRepository
) : SingleListUseCase<Animal>() {

    override fun buildUseCase(params: Unit?): Flow<List<Animal>> = repository.getCats()
}