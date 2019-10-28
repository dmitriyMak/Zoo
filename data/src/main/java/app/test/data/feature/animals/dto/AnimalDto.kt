package app.test.data.feature.animals.dto

import com.google.gson.annotations.SerializedName

data class AnimalDto(
    @SerializedName("url") val url: String,
    @SerializedName("title") val name: String
)