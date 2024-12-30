package com.example.myproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myproduct.databinding.ItemCakesBinding

class CakesAdapter(val cakesList: ArrayList<Cakes>, val listener: (position: Int) -> Unit) : RecyclerView.Adapter<CakesAdapter.CakesViewHolder>() {

    inner class CakesViewHolder(val binding: ItemCakesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cakes: Cakes){
            binding.apply {
                tvName.text = cakes.name
                tvDescription.text = cakes.desc
                tvPrice.text = cakes.price
                Glide.with(itemView).load(cakes.image).into(ivFruit)
            }
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val binding = CakesViewHolder(ItemCakesBinding.inflate(LayoutInflater.from(parent.context),parent, false))
        return binding
    }

    override fun getItemCount(): Int {
        return cakesList.size
    }

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        holder.bind(cakesList[position])
        holder.itemView.setOnClickListener {
            listener(position)

        }

    }

}























