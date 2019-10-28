package app.test.data.feature.animals.repository

import app.test.data.core.di.qualifires.Remote
import app.test.data.feature.animals.datasource.AnimalsDataSource
import app.test.data.feature.animals.dto.AnimalDto
import app.test.domain.core.mapper.Mapper
import app.test.domain.feature.animals.model.Animal
import app.test.domain.feature.animals.repository.AnimalsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AnimalsDataRepository @Inject constructor(
    @Remote private val dataSource: AnimalsDataSource,
    private val mapper: Mapper<AnimalDto, Animal>
) : AnimalsRepository {

    override fun getCats(): Flow<List<Animal>> =
        dataSource.getCats().map { mapper.mapFromObjects(it) }

    override fun getDogs(): Flow<List<Animal>> =
        dataSource.getDogs().map { mapper.mapFromObjects(it) }
}