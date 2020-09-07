package com.example.catsapp.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.catsapp.R
import com.example.catsapp.models.ImageFull

class FavouritesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.favourites_list_item, parent, false)) {
    private var favouriteItemImage: ImageView? = null
    var favouriteItemButton: Button? = null
    private var imageURL: String? = null

    init {
        favouriteItemImage = itemView.findViewById(R.id.favourite_image_view)
        favouriteItemButton = itemView.findViewById(R.id.favourite_item_button)
    }

    fun bind(image: ImageFull) {
        imageURL = image.url
        favouriteItemButton?.text = "UN-FAV IT"
    }
}