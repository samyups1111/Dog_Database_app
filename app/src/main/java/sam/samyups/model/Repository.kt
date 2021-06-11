package sam.samyups.model

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import sam.samyups.api.RetrofitObject
import sam.samyups.room.CacheMapper
import sam.samyups.room.DogDao

class Repository constructor(private val dogDao: DogDao) {

    private val cacheMapper = CacheMapper()

    suspend fun getDogBreed(): List<Dog>? {

        val dogType = object : TypeToken<List<Dog>>() {}.type
        var dogList = cacheMapper.mapFromEntityList(dogDao.get())

        if (dogList.isEmpty()) {
            dogList = Gson().fromJson<List<Dog>>(RetrofitObject.DogApi.getBreeds(), dogType)
            val toCacheList = cacheMapper.mapToEntityList(dogList)
            dogDao.insert(toCacheList)
        }

        return dogList
    }
}