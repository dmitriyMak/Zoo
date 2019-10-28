package app.test.presentation.feature.app.vm

import androidx.lifecycle.MutableLiveData
import app.test.presentation.core.vm.BaseVm
import javax.inject.Inject

class AppVm @Inject constructor() : BaseVm() {

    val tabPositionLD = MutableLiveData(0)

    fun setPosition(position: Int) {
        if (tabPositionLD.value == position) return
        tabPositionLD.value = position
    }
}