package app.test.presentation.core.ui.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import app.test.presentation.core.vm.BaseVm
import app.test.presentation.core.vm.factory.ViewModelFactory
import app.test.presentation.extensions.viewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<VM : BaseVm> : AppCompatActivity(), HasAndroidInjector {

    @Inject
    protected lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract val token: Class<VM>

    protected lateinit var viewModel: VM
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        viewModel = viewModel(token, viewModelFactory)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}