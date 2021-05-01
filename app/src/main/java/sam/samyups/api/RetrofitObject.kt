package sam.samyups.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sam.samyups.util.Constants

object RetrofitObject {

    private val retrofitApi: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val DogApi: Api by lazy {
        retrofitApi.create(Api::class.java)
    }
}

