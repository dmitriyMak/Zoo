package app.test.data.feature.animals.mapper

import app.test.data.feature.animals.dto.AnimalDto
import app.test.domain.core.mapper.Mapper
import app.test.domain.feature.animals.model.Animal
import javax.inject.Inject

class AnimalToDomainMapper @Inject constructor() : Mapper<AnimalDto, Animal> {

    override fun mapFromObject(source: AnimalDto): Animal = source.run {
        Animal(
            id = name.substringAfter(" "),
            url = url,
            name = name
        )
    }
}