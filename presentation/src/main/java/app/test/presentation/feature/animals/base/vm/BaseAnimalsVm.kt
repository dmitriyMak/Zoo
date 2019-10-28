package app.test.presentation.feature.animals.base.vm

import androidx.lifecycle.MutableLiveData
import app.test.domain.feature.animals.model.Animal
import app.test.presentation.core.vm.BaseVm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseAnimalsVm : BaseVm() {

    val animalsLD = MutableLiveData<List<Animal>>()

    protected abstract suspend fun loadAnimals(): Flow<List<Animal>>

    fun getData() = launch {
        if (animalsLD.value.isNullOrEmpty()) {
            loadAnimals().collect { animalsLD.value = it }
        }
    }
}