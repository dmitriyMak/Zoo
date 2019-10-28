package app.test.domain.core.interactor

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<T, in Params> {

    suspend operator fun invoke(params: Params? = null): Flow<T>
}