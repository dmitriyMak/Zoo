package app.test.domain.feature.animals.repository

import app.test.domain.feature.animals.model.Animal
import kotlinx.coroutines.flow.Flow

interface AnimalsRepository {

    fun getCats(): Flow<List<Animal>>

    fun getDogs(): Flow<List<Animal>>
}