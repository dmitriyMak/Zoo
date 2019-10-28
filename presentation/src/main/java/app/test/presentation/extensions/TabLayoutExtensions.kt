package app.test.presentation.extensions

import com.google.android.material.tabs.TabLayout

inline fun TabLayout.addTabSelectedListener(crossinline action: (Int) -> Unit) {
    this.addOnTabSelectedListener(
        object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let(action)
            }
        }
    )
}