package com.example.catsapp.ui.breed

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catsapp.R
import com.example.catsapp.models.Breed

class BreedViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.breed_list_item, parent, false)) {
    private var breedNameView: TextView? = null
    private var descriptionView: TextView? = null

    init {
        breedNameView = itemView.findViewById(R.id.breed_name)
        descriptionView = itemView.findViewById(R.id.description)
    }

    fun bind(breed: Breed) {
        var breedName = breed.name

        if (breed.altNames != null && breed.altNames.isNotEmpty()) {
            breedName += "/" + breed.altNames
        }

        breedNameView?.text = breedName
        descriptionView?.text = breed.temperament
    }
}