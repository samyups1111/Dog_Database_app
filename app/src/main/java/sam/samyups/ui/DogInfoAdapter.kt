package sam.samyups.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sam.samyups.R
import sam.samyups.model.Dog

class DogInfoAdapter: RecyclerView.Adapter<DogInfoViewHolder>() {

    var currentDog = Dog()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_info_recycler_item, parent, false)
        return DogInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogInfoViewHolder, position: Int) {
        holder.bind(currentDog)
    }

    override fun getItemCount(): Int {
        return 1
    }

    fun getCurrentDog(dog: Dog) {
        currentDog = dog
    }


}