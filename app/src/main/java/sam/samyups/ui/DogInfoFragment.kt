package sam.samyups.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import sam.samyups.databinding.FragmentDogInfoBinding
import sam.samyups.model.MainViewModel
import sam.samyups.model.Repository


class DogInfoFragment : Fragment() {

    private val TAG = "DogInfoFragment"
    private val repository = Repository()
    private var binding : FragmentDogInfoBinding? = null
    private val mainViewModel : MainViewModel by activityViewModels {
        MainViewModel.ViewModelFactory(repository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragmentBinding = FragmentDogInfoBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mainViewModel
        }
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        mainViewModel.currentDog.observe(viewLifecycleOwner, Observer { dog ->
            binding?.dogInfoName?.text = dog.name
            binding?.temperament?.text = dog.temperament
            binding?.lifespan?.text = dog.life_span
            binding?.altNames?.text = dog.alt_names
            binding?.wikipediaUrl?.text = dog.wikipedia_url
            binding?.origin?.text = dog.origin
            binding?.weight?.text = dog.weight.toString()
            binding?.countryCode?.text = dog.country_code
            binding?.height?.text = dog.height.toString()

        })
    }
}