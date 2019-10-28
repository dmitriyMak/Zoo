package app.test.presentation.feature.app.ui

import android.os.Bundle
import androidx.fragment.app.commitNow
import androidx.lifecycle.observe
import app.test.presentation.R
import app.test.presentation.core.ui.activity.BaseActivity
import app.test.presentation.extensions.addTabSelectedListener
import app.test.presentation.feature.animals.cats.ui.CatsFragment
import app.test.presentation.feature.animals.dogs.ui.DogsFragment
import app.test.presentation.feature.app.vm.AppVm
import kotlinx.android.synthetic.main.activity_container.*

class AppActivity : BaseActivity<AppVm>() {

    private val fragments = listOf(CatsFragment.newInstance(), DogsFragment.newInstance())

    override val layoutRes = R.layout.activity_container
    override val token = AppVm::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkScreenExistence()
        tlZoo.addTab(tlZoo.newTab().setText(R.string.cats))
        tlZoo.addTab(tlZoo.newTab().setText(R.string.dogs))
        tlZoo.addTabSelectedListener { viewModel.setPosition(it) }
        viewModel.tabPositionLD.observe(this) { position ->
            tlZoo.getTabAt(position)?.select()
            selectFragment(position)
        }
        ivBack.setOnClickListener { finishAndRemoveTask() }
    }

    private fun selectFragment(position: Int) {
        val fragmentToAttachTag = fragments[position]::class.java.simpleName
        supportFragmentManager.commitNow {
            supportFragmentManager.fragments.forEach { attachedFragment ->
                val attachedFragmentTag = attachedFragment::class.java.simpleName
                if (fragmentToAttachTag == attachedFragmentTag) {
                    show(attachedFragment)
                } else {
                    hide(attachedFragment)
                }
            }
        }
    }

    private fun checkScreenExistence() {
        fragments.forEach { fragment ->
            val tag = fragment::class.java.simpleName
            val attachedFragment = supportFragmentManager.findFragmentByTag(tag)
            supportFragmentManager.commitNow {
                if (attachedFragment == null) add(flContainer.id, fragment, tag)
            }
        }
    }
}
