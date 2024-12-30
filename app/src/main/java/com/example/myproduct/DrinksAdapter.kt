package com.example.myproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myproduct.databinding.ItemDrinksBinding

class DrinksAdapter(val drinksList: ArrayList<Drinks>, val listener: (position: Int) -> Unit) : RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>() {

    inner class DrinksViewHolder(val binding: ItemDrinksBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cakes: Drinks){
            binding.apply {
                tvName.text = cakes.name
                tvDescription.text = cakes.desc
                tvPrice.text = cakes.price
                Glide.with(itemView).load(cakes.image).into(ivFruit)
            }
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val binding = DrinksViewHolder(ItemDrinksBinding.inflate(LayoutInflater.from(parent.context),parent, false))
        return binding
    }

    override fun getItemCount(): Int {
        return drinksList.size
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        holder.bind(drinksList[position])
        holder.itemView.setOnClickListener {
            listener(position)

        }

    }

}























