package app.test.domain.feature.animals.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal(val id: String, val url: String, val name: String) : Parcelable