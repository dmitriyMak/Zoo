package app.test.data.feature.animals.api

import app.test.data.feature.animals.response.AnimalsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimalsApi {

    @GET("xim/api.php/")
    suspend fun getCats(@Query("query") cat: String = "cat"): AnimalsResponseDto

    @GET("xim/api.php/")
    suspend fun getDogs(@Query("query") dog: String = "dog"): AnimalsResponseDto
}