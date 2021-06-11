package sam.samyups.ui

import android.view.View
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import sam.samyups.R
import sam.samyups.model.Dog
import sam.samyups.model.MainViewModel

class DogNamesRecyclerViewHolder (
    recyclerViewItem: View,
    private val mainViewModel: MainViewModel
    ) : RecyclerView.ViewHolder(recyclerViewItem) {

    private val TAG = "ViewHolder"
    private val dogNameTextView: TextView = recyclerViewItem.findViewById(R.id.dog_name)

    fun bind(dog: Dog, position: Int) {

        dogNameTextView.text = dog.name

        dogNameTextView.setOnClickListener {
            val navController = Navigation.findNavController(itemView)
            navController.navigate(R.id.action_dogNamesFragment_to_dogInfoFragment)
            mainViewModel.setDog(dog)
            mainViewModel.setCurrentIndex(position)
        }
    }
}