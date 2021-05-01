package sam.samyups.ui

import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import sam.samyups.R
import sam.samyups.model.Dog
import sam.samyups.model.MainViewModel

class DogNamesRecyclerViewHolder(recyclerViewItem: View, mainViewModel: MainViewModel): RecyclerView.ViewHolder(recyclerViewItem) {

    private val TAG = "ViewHolder"
    private val dogNameTextView: TextView = recyclerViewItem.findViewById(R.id.dog_name)
    private val viewModelApi = mainViewModel

    fun bind(dog: Dog) {
        dogNameTextView.text = dog.name

        dogNameTextView.setOnClickListener {

            Toast.makeText(dogNameTextView.context, "Woof Woof", Toast.LENGTH_SHORT).show()
            val navController = Navigation.findNavController(itemView)
            navController.navigate(R.id.action_dogNamesFragment_to_dogInfoFragment)

            viewModelApi.setDog(dog)
            Log.d(TAG, "dog.name = ${dog.name}")
            Log.d(TAG, "viewModelApi.currentDog = ${viewModelApi.currentDog.value?.name}")

        }
    }
}