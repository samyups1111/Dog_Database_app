package sam.samyups.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import sam.samyups.R
import sam.samyups.model.Dog
import sam.samyups.model.MainViewModel
import java.util.*
import kotlin.collections.ArrayList

class DogNamesRecyclerViewAdapter(private val mainViewModel: MainViewModel): RecyclerView.Adapter<DogNamesRecyclerViewHolder>(), Filterable {

    private var dogList = emptyList<Dog>()
    var filteredDogList = emptyList<Dog>()
    val TAG = "Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogNamesRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        Log.d(TAG, "onCreateViewHolder")
        return DogNamesRecyclerViewHolder(view, mainViewModel)
    }

    override fun onBindViewHolder(holder: DogNamesRecyclerViewHolder, position: Int) {
        Log.d(TAG,  "onBindViewHolder")
        val currentDog = filteredDogList[position]
        holder.bind(currentDog)
    }

    override fun getItemCount(): Int {
        return filteredDogList.size
    }

    fun updateList(list: List<Dog>) {
        Log.d(TAG, "updateList")
        dogList = list
        filteredDogList = dogList
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        Log.d(TAG, "getFilter")
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filteredDogList = dogList
                } else {
                    val resultList = ArrayList<Dog>()
                    for (row in dogList) {
                        if (row.name.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    filteredDogList = resultList
                }
                val filter = FilterResults()
                filter.values = filteredDogList
                return filter
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredDogList = results?.values as ArrayList<Dog>
                notifyDataSetChanged()
            }
        }
    }
}