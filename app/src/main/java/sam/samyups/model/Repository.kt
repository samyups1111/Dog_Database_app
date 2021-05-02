package sam.samyups.model

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import sam.samyups.api.RetrofitObject

class Repository {

    val TAG = "Repo: getDogBreed: "

    suspend fun getDogBreed(): List<Dog>? {

        val dogType = object : TypeToken<List<Dog>>() {}.type
        val dogList = Gson().fromJson<List<Dog>>(RetrofitObject.DogApi.getBreeds(), dogType)

        Log.d(TAG, "dogList.size = ${dogList.size}")
        Log.d(TAG, "dogList[0] = ${dogList[0]}")

        return dogList
    }
}