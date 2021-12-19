package com.example.coffeeit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeit.databinding.FragmentStyleBinding
import com.example.coffeeit.helpers.CoffeeItemAdapter
import com.example.coffeeit.helpers.OnClickListener
import com.example.coffeeit.models.CoffeeAttributes
import com.example.coffeeit.models.CoffeeItem
import com.example.coffeeit.viewmodels.HomeViewModel


class StyleFragment : Fragment() {
    private var binding: FragmentStyleBinding? = null
    private lateinit var adapter: CoffeeItemAdapter
    private val coffeeItemList: MutableList<CoffeeItem> = mutableListOf()

    private val sharedViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentStyleBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        setUpAdapter()

        sharedViewModel.coffeeAttributesLiveData?.observe(this.viewLifecycleOwner, Observer {
            if (it != null){
                populateList()
            } else{
                Toast.makeText(this.activity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })

        return fragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun setUpAdapter() {
        adapter = CoffeeItemAdapter(requireContext(),coffeeItemList,
            OnClickListener { item ->
                sharedViewModel.setChosenStyle(item.name)
                findNavController().navigate(R.id.action_styleFragment_to_sizeFragment)
            }
        )

        binding?.itemsRV?.adapter = adapter
        binding?.itemsRV?.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun populateList() {
        coffeeItemList.clear()
        coffeeItemList.addAll(sharedViewModel.getStyles())
        adapter.notifyDataSetChanged()
    }


}