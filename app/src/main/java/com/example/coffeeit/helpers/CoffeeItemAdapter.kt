package com.example.coffeeit.helpers

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeit.SizeActivity
import com.example.coffeeit.databinding.CoffeeItemLayoutBinding
import com.example.coffeeit.models.CoffeeItem

class CoffeeItemAdapter(private val context: Context, private val coffeeItemList :MutableList<CoffeeItem>)
    : RecyclerView.Adapter<CoffeeItemAdapter.CoffeeItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeItemViewHolder {
        val binding = CoffeeItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return CoffeeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoffeeItemViewHolder, position: Int) {
        val coffeeItem = coffeeItemList[position]
        holder.bind(coffeeItem)
    }

    override fun getItemCount(): Int {
        return coffeeItemList.size
    }


    inner class CoffeeItemViewHolder(coffeeItemLayoutBinding: CoffeeItemLayoutBinding)
        : RecyclerView.ViewHolder(coffeeItemLayoutBinding.root){

        private val binding = coffeeItemLayoutBinding

        fun bind(coffeeItem: CoffeeItem){
            binding.title.text = coffeeItem.name

            binding.root.setOnClickListener {
                val intent = Intent(context, SizeActivity::class.java)
                intent.putExtra("chosenItem", coffeeItem.name)
                intent.putExtra("typeCategory", coffeeItem.typeCategory)
                context.startActivity(intent)
            }
        }

    }
}