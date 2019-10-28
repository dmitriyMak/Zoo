package app.test.presentation.core.ui.decorator

import android.graphics.Rect
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView

class SpaceDecorator(@Px val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) = with(outRect) {
        top = space
        bottom = space
        left = space
        right = space
    }
}