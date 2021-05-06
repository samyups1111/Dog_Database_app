package sam.samyups.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sam.samyups.R
import sam.samyups.model.Dog

class DogInfoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val dogTemperamentTextView: TextView = view.findViewById(R.id.temperament)
    private val dogLifeSpanTextView: TextView = view.findViewById(R.id.lifespan)
    private val dogWeightTextView: TextView = view.findViewById(R.id.weight)
    private val dogCountryCodeTextView: TextView = view.findViewById(R.id.country_code)
    private val dogHeightTextView: TextView = view.findViewById(R.id.height)
    private val dogBredForTextView: TextView = view.findViewById(R.id.bred_for)
    private val dogBreedGroupTextView: TextView = view.findViewById(R.id.breed_group)

    fun bind(dog: Dog) {
        dogTemperamentTextView.text = dog.temperament
        dogLifeSpanTextView.text = dog.life_span
        dogWeightTextView.text = dog.weight.toString()
        dogCountryCodeTextView.text = dog.country_code
        dogHeightTextView.text = dog.height.toString()
        dogBredForTextView.text = dog.bred_for
        dogBreedGroupTextView.text = dog.breed_group
    }
}