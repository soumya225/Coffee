package com.example.coffeeit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}