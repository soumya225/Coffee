package com.example.coffeeit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeit.databinding.FragmentOverviewBinding
import com.example.coffeeit.viewmodels.HomeViewModel

class OverviewFragment : Fragment() {
    private var binding: FragmentOverviewBinding? = null

    private val sharedViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentOverviewBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    fun editStyle() {
        findNavController().navigate(R.id.action_overviewFragment_to_styleFragment)
    }

    fun editSize() {
        findNavController().navigate(R.id.action_overviewFragment_to_sizeFragment)
    }

    fun brew() {
        val order: String = "Brewing a ${sharedViewModel.chosenSize.value} ${sharedViewModel.chosenStyle.value}"
        Toast.makeText(this.context, order, Toast.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            overviewFragment = this@OverviewFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}