package app.test.presentation.core.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import timber.log.Timber

abstract class BaseVm : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()

    final override val coroutineContext =
        Dispatchers.Main.immediate + job + CoroutineExceptionHandler { _, e ->
            Timber.e(e)
        }

    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }

}