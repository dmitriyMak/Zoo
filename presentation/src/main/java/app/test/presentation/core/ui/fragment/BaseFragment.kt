package app.test.presentation.core.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import app.test.presentation.core.vm.BaseVm
import app.test.presentation.core.vm.factory.ViewModelFactory
import app.test.presentation.extensions.viewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<VM : BaseVm> : Fragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract val token: Class<VM>

    protected lateinit var viewModel: VM
        private set

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModel(token, viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutRes, container, false)
}