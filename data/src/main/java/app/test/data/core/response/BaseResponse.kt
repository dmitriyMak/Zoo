package app.test.data.core.response

import com.google.gson.annotations.SerializedName

interface BaseResponse<T> {

    @get:SerializedName("message")
    val message: String?

    @get:SerializedName("data")
    val data: List<T>
}