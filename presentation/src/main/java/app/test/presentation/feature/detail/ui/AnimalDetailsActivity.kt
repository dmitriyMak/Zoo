package app.test.presentation.feature.detail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.observe
import app.test.domain.feature.animals.model.Animal
import app.test.presentation.R
import app.test.presentation.core.ui.activity.BaseActivity
import app.test.presentation.extensions.loadImage
import app.test.presentation.feature.detail.vm.AnimalDetailsVm
import kotlinx.android.synthetic.main.activity_animal_details.*

class AnimalDetailsActivity : BaseActivity<AnimalDetailsVm>() {

    override val layoutRes = R.layout.activity_animal_details
    override val token = AnimalDetailsVm::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setAnimal(intent.getParcelableExtra(ANIMAL))
        viewModel.animalLD.observe(this, ::bind)
        ivBack.setOnClickListener { onBackPressed() }
    }

    private fun bind(animal: Animal) = with(animal) {
        ivIcon.loadImage(url)
        tvOrder.text = id
        tvTitle.text = name
    }

    companion object {
        private const val ANIMAL = "animal"

        fun newInstance(context: Context, animal: Animal) =
            Intent(context, AnimalDetailsActivity::class.java).also { intent ->
                intent.putExtra(ANIMAL, animal)
            }
    }
}