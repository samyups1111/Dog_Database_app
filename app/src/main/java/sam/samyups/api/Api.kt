package sam.samyups.api

import com.google.gson.JsonElement
import retrofit2.http.GET

interface Api {
    @GET("v1/breeds")
    suspend fun getBreeds(): JsonElement

}