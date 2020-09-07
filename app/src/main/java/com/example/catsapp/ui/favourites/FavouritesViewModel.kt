package com.example.catsapp.ui.favourites

import androidx.lifecycle.ViewModel
import com.example.catsapp.models.Favourite
import com.example.catsapp.models.ImageFull

class FavouritesViewModel : ViewModel() {
    var favouritesList: ArrayList<Favourite> = ArrayList()
    var imagesList: ArrayList<ImageFull> = ArrayList()
}