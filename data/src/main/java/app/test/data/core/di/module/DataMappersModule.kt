package app.test.data.core.di.module

import app.test.data.feature.animals.dto.AnimalDto
import app.test.data.feature.animals.mapper.AnimalToDomainMapper
import app.test.domain.core.mapper.Mapper
import app.test.domain.feature.animals.model.Animal
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataMappersModule {

    @Binds
    @Singleton
    fun bindAnimalToDomainMapper(mapper: AnimalToDomainMapper): Mapper<AnimalDto, Animal>
}