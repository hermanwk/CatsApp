package com.example.catsapp.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catsapp.models.ImageFull
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.breed_dialog.view.*
import kotlinx.android.synthetic.main.fragment_vote.view.*

class FavouritesListAdapter(private val list: List<ImageFull>, private val listener: (ImageFull) -> Unit)
    : RecyclerView.Adapter<FavouritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FavouritesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val image: ImageFull = list[position]
        holder.bind(image)
        holder.itemView.favourite_item_button.setOnClickListener { listener(image) }

        Picasso.get().load(image.url).into(holder.itemView.favourite_image_view)
    }

    override fun getItemCount(): Int = list.size

}