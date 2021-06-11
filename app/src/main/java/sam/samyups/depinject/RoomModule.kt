package sam.samyups.depinject

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import sam.samyups.room.DogDao
import sam.samyups.room.DogDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideDogDb(@ApplicationContext context: Context): DogDatabase{
        return Room.databaseBuilder(
            context,
            DogDatabase::class.java,
            DogDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDogDao(dogDatabase: DogDatabase): DogDao{
        return dogDatabase.dogDao()
    }
}