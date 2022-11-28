package com.lutfullayevmuhammad.quran.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lutfullayevmuhammad.quran.R
import com.lutfullayevmuhammad.quran.core.adapters.home.HomeAdapter
import com.lutfullayevmuhammad.quran.core.helper.ViewModelProviderFactory
import com.lutfullayevmuhammad.quran.core.utils.VerticalItemDecoration
import com.lutfullayevmuhammad.quran.databinding.HomeFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlin.math.roundToInt

class HomeFragment : DaggerFragment() {

    private val binding by lazy {
        HomeFragmentBinding.inflate(layoutInflater)
    }

    private var adapter = HomeAdapter()

    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory

    private val viewModel: HomeViewModel by viewModels { vmProviderFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.homeListLiveData.observe(viewLifecycleOwner) {
            adapter.data = it.chapters
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it?.error, Toast.LENGTH_SHORT).show()
        }

        viewModel.networkErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "networkErrorLiveData", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val size = resources.getDimension(R.dimen._12db)
        val decoration = VerticalItemDecoration(size.roundToInt())
        binding.homeList.addItemDecoration(decoration)

        adapter.onItemClick = {
            val action =
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it.id.toString())
            findNavController().navigate(action)
        }

        viewModel.suraList("ru")
        binding.homeList.adapter = adapter
        binding.homeList.layoutManager =
            LinearLayoutManager(requireContext())
    }

}