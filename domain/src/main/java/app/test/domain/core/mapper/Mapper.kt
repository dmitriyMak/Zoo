package app.test.domain.core.mapper

interface Mapper<S, D> {

    fun mapFromObject(source: S): D

    fun mapFromObjects(sources: Collection<S>) = sources.map(::mapFromObject)
}