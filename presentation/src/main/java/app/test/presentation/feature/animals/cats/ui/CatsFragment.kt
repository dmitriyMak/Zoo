package app.test.presentation.feature.animals.cats.ui

import app.test.presentation.feature.animals.base.ui.BaseAnimalsFragment
import app.test.presentation.feature.animals.cats.vm.CatsVm

class CatsFragment : BaseAnimalsFragment<CatsVm>() {

    override val token = CatsVm::class.java

    companion object {
        fun newInstance() = CatsFragment()
    }
}