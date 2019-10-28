package app.test.presentation.feature.animals.base.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.test.domain.feature.animals.model.Animal
import app.test.presentation.R
import app.test.presentation.extensions.loadImage
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_animal.*

class AnimalsAdapter(
    private val click: (Animal) -> Unit
) : RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>() {

    private val items = mutableListOf<Animal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder =
        AnimalViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_animal, parent, false)
        ).apply { itemView.setOnClickListener { withAdapterPosition { click(it) } } }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun update(list: List<Animal>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    private fun RecyclerView.ViewHolder.withAdapterPosition(action: (Animal) -> Unit) {
        with(adapterPosition) {
            if (this != RecyclerView.NO_POSITION && this >= 0 && this < items.size) {
                action(items[this])
            }
        }
    }

    class AnimalViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView), LayoutContainer {
        override val containerView: View? = itemsView

        fun bind(animal: Animal) = with(animal) {
            ivIcon.loadImage(url)
            tvOrder.text = id
            tvTitle.text = name
        }
    }
}