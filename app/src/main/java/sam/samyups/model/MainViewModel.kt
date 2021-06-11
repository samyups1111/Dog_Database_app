package sam.samyups.model

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject constructor(
    private val repository:Repository)
    : ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    var dogListCopy = emptyList<Dog>()
    private var _currentDog = MutableLiveData<Dog>()
    val currentDog: LiveData<Dog> = _currentDog
    private val _currentIndex = MutableLiveData<Int>()
    val currentIndex : LiveData<Int> = _currentIndex

    fun getDogList(): MutableLiveData<List<Dog>> {
        viewModelScope.launch {
            _dogList.value = repository.getDogBreed()
            dogListCopy = _dogList.value!!
        }
        return _dogList
    }

    fun setDog(dog: Dog) {
        _currentDog.value = dog
    }

    fun setCurrentIndex(index: Int) {
        _currentIndex.value = index
    }
}