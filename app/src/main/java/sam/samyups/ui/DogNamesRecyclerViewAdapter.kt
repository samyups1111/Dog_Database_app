package sam.samyups.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sam.samyups.R
import sam.samyups.model.Dog
import sam.samyups.model.MainViewModel
import sam.samyups.util.ViewModelInterface

class DogNamesRecyclerViewAdapter(private val mainViewModel: MainViewModel): RecyclerView.Adapter<DogNamesRecyclerViewHolder>() {

    private var dogList = emptyList<Dog>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogNamesRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return DogNamesRecyclerViewHolder(view, mainViewModel)
    }

    override fun onBindViewHolder(holder: DogNamesRecyclerViewHolder, position: Int) {
        val currentDog = dogList[position]
        holder.bind(currentDog)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    fun updateList(list: List<Dog>) {
        dogList = list
        notifyDataSetChanged()
    }
}