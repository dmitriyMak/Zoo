package app.test.presentation.feature.animals.dogs.ui

import app.test.presentation.feature.animals.base.ui.BaseAnimalsFragment
import app.test.presentation.feature.animals.dogs.vm.DogsVm

class DogsFragment : BaseAnimalsFragment<DogsVm>() {

    override val token = DogsVm::class.java

    companion object {
        fun newInstance() = DogsFragment()
    }
}