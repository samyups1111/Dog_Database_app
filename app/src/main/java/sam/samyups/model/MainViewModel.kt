package sam.samyups.model

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList : LiveData<List<Dog>> = _dogList


    private var _currentDog = MutableLiveData<Dog>()
    val currentDog: LiveData<Dog> = _currentDog

    private val dog = MutableLiveData<Dog>()

    fun getDogList(): MutableLiveData<List<Dog>> {
        viewModelScope.launch {
            _dogList.value = repository.getDogBreed()
        }
        return _dogList
    }

    fun getDog() = currentDog

    fun setDog(dog: Dog) {
        _currentDog.value = dog
    }

    class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return sam.samyups.model.MainViewModel(repository) as T
        }

    }
}