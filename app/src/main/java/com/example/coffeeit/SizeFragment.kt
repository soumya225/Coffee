package com.example.coffeeit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeit.databinding.FragmentSizeBinding
import com.example.coffeeit.databinding.FragmentStyleBinding
import com.example.coffeeit.helpers.CoffeeItemAdapter
import com.example.coffeeit.helpers.OnClickListener
import com.example.coffeeit.models.CoffeeAttributes
import com.example.coffeeit.models.CoffeeItem
import com.example.coffeeit.viewmodels.HomeViewModel


class SizeFragment : Fragment() {
    private var binding: FragmentSizeBinding? = null
    private lateinit var adapter: CoffeeItemAdapter
    private val coffeeItemList: MutableList<CoffeeItem> = mutableListOf()

    private val sharedViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentSizeBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        setUpAdapter()

        populateList(sharedViewModel.coffeeAttributesLiveData?.value)

        return fragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun setUpAdapter() {
        adapter = CoffeeItemAdapter(requireContext(),coffeeItemList,
            OnClickListener { item ->
                sharedViewModel.setChosenSize(item.name)
                findNavController().navigate(R.id.action_sizeFragment_to_overviewFragment)
            }
        )

        binding?.itemsRV?.adapter = adapter
        binding?.itemsRV?.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun populateList(result: CoffeeAttributes.Result?) {
        coffeeItemList.clear()
        val coffeeTypeName = sharedViewModel.chosenStyle.value
        val coffeeType = result?.types?.findLast { it.name == coffeeTypeName }
        if (coffeeType != null) {
            for (i in coffeeType.sizes){
                val size = result.sizes.findLast { it._id == i }

                val coffeeItem = size?.let { CoffeeItem(name = it.name) }

                if (coffeeItem != null) {
                    coffeeItemList.add(coffeeItem)
                }
            }
        }
    }
}