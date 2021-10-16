# Dog Database

## Intro:

Dog Database retrieves data from the [https://thedogapi.com/] API.
The user can select a dog from the list to see details pertatining to that breed. The 
search bar allows for filtering of the list. 

## Architecture:

* MVVM
  * [Model](https://github.com/samyups1111/Dog_Database_app/tree/master/app/src/main/java/sam/samyups/model)
  * [View](https://github.com/samyups1111/Dog_Database_app/tree/master/app/src/main/java/sam/samyups/ui)
  * [ViewModel](https://github.com/samyups1111/Dog_Database_app/blob/master/app/src/main/java/sam/samyups/model/MainViewModel.kt)
 
## Libraries:

* [Room Persistence Library](https://github.com/samyups1111/Dog_Database_app/tree/master/app/src/main/java/sam/samyups/room)
* [Retrofit](https://github.com/samyups1111/Dog_Database_app/tree/master/app/src/main/java/sam/samyups/retrofit)
* [Picasso](https://github.com/samyups1111/Dog_Database_app/blob/master/app/src/main/java/sam/samyups/ui/DogInfoFragment.kt)

## Other:

* [RecyclerView](https://github.com/samyups1111/Dog_Database_app/blob/master/app/src/main/java/sam/samyups/ui/DogNamesRecyclerViewAdapter.kt)
* [Filter Search](https://github.com/samyups1111/Dog_Database_app/blob/master/app/src/main/java/sam/samyups/ui/DogNamesRecyclerViewAdapter.kt)
* Fragments

<img src="https://github.com/samyups1111/retrofitTraining/blob/master/app/src/main/res/mipmap-hdpi/main_dog.png" height="600" width="300" />

<img src="https://github.com/samyups1111/retrofitTraining/blob/master/app/src/main/res/mipmap-hdpi/dog_list.png" height="600" width="300" />
