package app.test.domain.core.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class AbstractUseCase<T, in Params> : BaseUseCase<T, Params> {

    protected abstract fun buildUseCase(params: Params? = null): Flow<T>

    final override suspend fun invoke(params: Params?): Flow<T> =
        buildUseCase(params).flowOn(Dispatchers.IO)
}