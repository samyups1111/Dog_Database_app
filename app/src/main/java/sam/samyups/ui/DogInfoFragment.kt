package sam.samyups.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import sam.samyups.R
import sam.samyups.databinding.FragmentDogInfoBinding
import sam.samyups.model.Dog
import sam.samyups.model.MainViewModel
import sam.samyups.model.Repository


class DogInfoFragment : Fragment() {

    private val TAG = "DogInfoFragment"
    private val repository = Repository()
    private var binding : FragmentDogInfoBinding? = null
    private val mainViewModel : MainViewModel by activityViewModels {
        MainViewModel.ViewModelFactory(repository)
    }
    private val dogInfoAdapter = DogInfoAdapter()
    private var thisIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragmentBinding = FragmentDogInfoBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        (activity as AppCompatActivity).supportActionBar?.title = "Breed:"
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = mainViewModel
        }
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initObserver()
        initButtons()
    }

    private fun initObserver() {
        mainViewModel.currentDog.observe(viewLifecycleOwner, Observer { dog ->
            binding?.dogInfoName?.text = dog.name
            dogInfoAdapter.getCurrentDog(dog)

            Picasso.with(context)
                    .load(dog?.image?.toString()?.substringAfterLast("=")?.dropLast(1))

                    .resize(900, 900)
                    .centerCrop()
                    .placeholder(R.drawable.loading_animation)
                    .into(binding?.dogInfoPic)
        })
    }

    private fun initRecyclerView() {
        binding?.dogInfoRecycler?.apply {
            adapter = dogInfoAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initButtons() {
        var thisDog = Dog()
        var nextDog = Dog()
        var previousDog = Dog()
        mainViewModel.currentIndex.observe(viewLifecycleOwner, Observer { index ->
            thisIndex = index
            Log.d(TAG, "currentIndex = $thisIndex")
        })
        mainViewModel.currentDog.observe(viewLifecycleOwner, Observer { dog ->
            thisDog = dog
            Log.d(TAG, "thisDog (1) = ${thisDog.name}")
            nextDog = try {mainViewModel.dogListCopy[thisIndex + 1] }
            catch (e: Exception) {mainViewModel.dogListCopy[mainViewModel.dogListCopy.size - 1]}
            Log.d(TAG, "nextDog(2) = ${nextDog.name}")
            previousDog = try {mainViewModel.dogListCopy[thisIndex - 1] ?: mainViewModel.dogListCopy[0]}
            catch (e: Exception) { mainViewModel.dogListCopy[0]}
            mainViewModel.setCurrentIndex(thisIndex)
        })

        binding?.previousButton?.setOnClickListener {
            if (mainViewModel.currentIndex.value!! > 0) {
                thisIndex -= 1
                mainViewModel.setDog(previousDog)
            }
        }

        binding?.nextButton?.setOnClickListener {
            if (mainViewModel.currentIndex.value!! < mainViewModel.dogListCopy.size - 1) {
                Log.d(TAG, "Next Button clicked")
                Log.d(TAG, "viewModel.getDog activated")
                Log.d(TAG, "newCurrentIndex = ${thisIndex + 1}")
                Log.d(TAG, "thisDog = ${thisDog.name}")
                Log.d(TAG, "nextDog = ${nextDog.name}")
                thisIndex += 1
                mainViewModel.setDog(nextDog)
                Log.d(TAG, "nexButton: thisDog.name = ${thisDog.name}")
            }

        }
    }
}