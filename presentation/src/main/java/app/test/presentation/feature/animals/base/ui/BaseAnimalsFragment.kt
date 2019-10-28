package app.test.presentation.feature.animals.base.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.test.presentation.R
import app.test.presentation.core.ui.decorator.SpaceDecorator
import app.test.presentation.core.ui.fragment.BaseFragment
import app.test.presentation.feature.animals.base.vm.BaseAnimalsVm
import app.test.presentation.feature.detail.ui.AnimalDetailsActivity
import kotlinx.android.synthetic.main.fragment_animals.*

abstract class BaseAnimalsFragment<VM : BaseAnimalsVm> : BaseFragment<VM>() {

    private val adapter = AnimalsAdapter { animal ->
        startActivity(AnimalDetailsActivity.newInstance(requireActivity(), animal))
    }

    override val layoutRes = R.layout.fragment_animals

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvAnimal.addItemDecoration(
            SpaceDecorator(requireContext().resources.getDimensionPixelSize(R.dimen.size_10dp))
        )
        rvAnimal.adapter = adapter
        rvAnimal.layoutManager = LinearLayoutManager(requireContext())
        adapter.registerAdapterDataObserver(
            object : RecyclerView.AdapterDataObserver() {
                override fun onChanged() {
                    savedInstanceState?.let { bundle ->
                        val position = bundle.getInt(SCROLL_POSITION)
                        arguments = bundleOf(SCROLL_POSITION to position)
                        getLinearLayoutManager()?.scrollToPosition(position)
                    }
                    adapter.unregisterAdapterDataObserver(this)
                }
            }
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.animalsLD.observe(this, adapter::update)
        viewModel.getData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val currentPosition = currentScrollPosition()
        val savedPosition = arguments?.getInt(SCROLL_POSITION) ?: 0
        val positionToSave = if (currentPosition == RecyclerView.NO_POSITION) {
            savedPosition
        } else {
            currentPosition
        }
        outState.putInt(SCROLL_POSITION, positionToSave)
    }

    private fun getLinearLayoutManager(): LinearLayoutManager? =
        rvAnimal?.layoutManager as? LinearLayoutManager

    private fun currentScrollPosition() =
        getLinearLayoutManager()?.findFirstCompletelyVisibleItemPosition() ?: 0

    private companion object {
        private const val SCROLL_POSITION = "scroll_position"
    }
}