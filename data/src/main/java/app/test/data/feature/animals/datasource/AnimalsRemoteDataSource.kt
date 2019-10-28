package app.test.data.feature.animals.datasource

import app.test.data.core.extnsions.typeFlow
import app.test.data.feature.animals.api.AnimalsApi
import app.test.data.feature.animals.dto.AnimalDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimalsRemoteDataSource @Inject constructor(
    private val api: AnimalsApi
) : AnimalsDataSource {

    override fun getCats(): Flow<List<AnimalDto>> = typeFlow {
        api.getCats().data
    }

    override fun getDogs(): Flow<List<AnimalDto>> = typeFlow {
        api.getDogs().data
    }
}