package sam.samyups.model

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    private val TAG = "ViewModel"

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList : LiveData<List<Dog>> = _dogList
    var dogListCopy = emptyList<Dog>()


    private var _currentDog = MutableLiveData<Dog>()
    val currentDog: LiveData<Dog> = _currentDog

    private val dog = Dog()

    private val _currentIndex = MutableLiveData<Int>()
    val currentIndex : LiveData<Int> = _currentIndex

    fun getDogList(): MutableLiveData<List<Dog>> {
        viewModelScope.launch {
            _dogList.value = repository.getDogBreed()
            dogListCopy = _dogList.value!!
        }
        return _dogList
    }

    fun getDog(index: Int): Dog {
        var mdog = Dog()
        Log.d(TAG, "mdog is blank = ${mdog.name}")
        Log.d(TAG, "index = $index")
        viewModelScope.launch {
            mdog = (repository.getDogBreed())!![index]
            Log.d(TAG, "mdog = ${mdog.name}")
        }
        Log.d(TAG, "mdog not blank. name = ${mdog.name}")
        return mdog
    }

    fun setDog(dog: Dog) {
        _currentDog.value = dog
    }

    fun setCurrentIndex(index: Int) {
        _currentIndex.value = index
    }

    class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return sam.samyups.model.MainViewModel(repository) as T
        }

    }
}