package sam.samyups.retrofit

import retrofit2.http.GET

interface DogRetrofit {

    @GET("v1/breeds")
    suspend fun getBreeds(): List<DogNetworkEntity>
}