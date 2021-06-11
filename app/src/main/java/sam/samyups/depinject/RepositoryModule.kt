package sam.samyups.depinject

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sam.samyups.model.Repository
import sam.samyups.room.DogDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        dogDao: DogDao)
    : Repository {
        return Repository(dogDao)
    }
}