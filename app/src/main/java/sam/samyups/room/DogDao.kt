package sam.samyups.room

import androidx.room.*
import sam.samyups.model.Dog

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dogCacheEntity: List<DogCacheEntity>)

    @Query("SELECT * FROM Dogs")
    suspend fun get(): List<DogCacheEntity>

    @Query("DELETE FROM Dogs")
    suspend fun delete()
}