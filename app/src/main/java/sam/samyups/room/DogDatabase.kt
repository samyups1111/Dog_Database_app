package sam.samyups.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import sam.samyups.util.TypeConverter

@Database(entities = [DogCacheEntity::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class DogDatabase : RoomDatabase() {

    abstract fun dogDao(): DogDao

    companion object{
        val DATABASE_NAME: String = "dog_db"
    }
}