package app.test.presentation.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*

inline fun <VM : ViewModel, reified T : FragmentActivity> T.viewModel(
    token: Class<VM>,
    factory: ViewModelProvider.Factory
): VM = viewModelStore.viewModel(token, factory)

inline fun <VM : ViewModel, reified T : Fragment> T.viewModel(
    token: Class<VM>,
    factory: ViewModelProvider.Factory
): VM = viewModelStore.viewModel(token, factory)

inline fun <VM : ViewModel, reified T : ViewModelStore> T.viewModel(
    token: Class<VM>,
    factory: ViewModelProvider.Factory
): VM = ViewModelProvider(this, factory)[token]

inline fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(
    liveData: L,
    noinline body: (T) -> Unit
) {
    liveData.observe(this, Observer(body))
}