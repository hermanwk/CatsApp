package com.example.catsapp.ui.breed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catsapp.models.Breed

class BreedListAdapter(private val list: List<Breed>, private val listener: (Breed) -> Unit)
    : RecyclerView.Adapter<BreedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BreedViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breed: Breed = list[position]
        holder.bind(breed)
        holder.itemView.setOnClickListener { listener(breed) }
    }

    override fun getItemCount(): Int = list.size

}