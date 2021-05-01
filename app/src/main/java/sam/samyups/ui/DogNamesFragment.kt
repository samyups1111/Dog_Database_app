package sam.samyups.ui

import android.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import sam.samyups.databinding.DogNamesFragmentBinding
import sam.samyups.model.MainViewModel
import sam.samyups.model.Repository

class DogNamesFragment : Fragment(){

    private val TAG = "DogNamesFragment"

    private var binding : DogNamesFragmentBinding? = null
    private val repository= Repository()
    private val mainViewModel : MainViewModel by activityViewModels {
        MainViewModel.ViewModelFactory(repository)
    }
    private lateinit var dogNamesAdapter: DogNamesRecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dogNamesAdapter = DogNamesRecyclerViewAdapter(mainViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBinding = DogNamesFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        initRecyclerView()
        return fragmentBinding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        initObserver()
    }

    private fun initBinding() {
        binding?.apply {
            viewModel = mainViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    private fun initRecyclerView() {
        Log.d(TAG, "initRecyclerview")
        binding?.recyclerview?.apply {
            adapter = dogNamesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initObserver() {
        mainViewModel.getDogList().observe(viewLifecycleOwner, Observer { dogList ->
            dogNamesAdapter.updateList(dogList)
        })
    }
}