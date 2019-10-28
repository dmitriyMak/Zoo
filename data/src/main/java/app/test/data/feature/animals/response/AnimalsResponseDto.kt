package app.test.data.feature.animals.response

import app.test.data.core.response.BaseResponse
import app.test.data.feature.animals.dto.AnimalDto

data class AnimalsResponseDto(
    override val message: String?,
    override val data: List<AnimalDto>
) : BaseResponse<AnimalDto>