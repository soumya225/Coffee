package com.example.coffeeit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeit.databinding.ActivityMainBinding
import com.example.coffeeit.helpers.CoffeeItemAdapter
import com.example.coffeeit.models.CoffeeAttributes
import com.example.coffeeit.models.CoffeeItem
import com.example.coffeeit.viewmodels.HomeViewModel

class SizeActivity : AppCompatActivity() {
    private lateinit var adapter: CoffeeItemAdapter
    private lateinit var b: ActivityMainBinding
    private lateinit var vm: HomeViewModel
    private val coffeeItemList: MutableList<CoffeeItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        setUpToolbar()
        setUpAdapter()

        vm = ViewModelProvider(this)[HomeViewModel::class.java]
        if (vm.coffeeAttributesLiveData?.value != null){
            populateList(vm.coffeeAttributesLiveData?.value!!)
            adapter.notifyDataSetChanged()
        } else{
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(b.toolbar)
        supportActionBar?.title = "Brew with Lex"
    }
    private fun setUpAdapter() {
        adapter = CoffeeItemAdapter(this,coffeeItemList)

        b.itemsRV.adapter = adapter
        b.itemsRV.layoutManager = LinearLayoutManager(this)
    }

    private fun populateList(result: CoffeeAttributes.Result) {
        val coffeeTypeName = intent.extras!!.get("typeCategory").toString()
        val coffeeType = result.types.findLast { it.name == coffeeTypeName }
        if (coffeeType != null) {
            for (i in coffeeType.sizes){
                val size = result.sizes.findLast { it._id == i }

                val coffeeItem = size?.let { CoffeeItem(name = it.name, typeCategory = coffeeType.name) }

                if (coffeeItem != null) {
                    coffeeItemList.add(coffeeItem)
                }
            }
        }
    }
}