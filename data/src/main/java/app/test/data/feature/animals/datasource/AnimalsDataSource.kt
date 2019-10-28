package app.test.data.feature.animals.datasource

import app.test.data.feature.animals.dto.AnimalDto
import kotlinx.coroutines.flow.Flow

interface AnimalsDataSource {

    fun getCats(): Flow<List<AnimalDto>>

    fun getDogs(): Flow<List<AnimalDto>>
}