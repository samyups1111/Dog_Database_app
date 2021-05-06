package sam.samyups.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
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
    private val dogInfoAdapter = DogInfoAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragmentBinding = FragmentDogInfoBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        (activity as AppCompatActivity).supportActionBar?.title = "Dog Breed"
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
    }

    private fun initObserver() {
        mainViewModel.currentDog.observe(viewLifecycleOwner, Observer { dog ->

            binding?.dogInfoName?.text = dog.name

            dogInfoAdapter.getCurrentDog(dog)

            Picasso.with(context)
                    .load(dog?.image?.toString()?.substringAfterLast("=")?.dropLast(1))
                    .resize(900, 900)
                    .centerCrop()
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
        binding?.previousButton?.setOnClickListener {
            val currentdog = dogInfoAdapter.currentDog.name
        }

        binding?.nextButton?.setOnClickListener {

        }
    }
}