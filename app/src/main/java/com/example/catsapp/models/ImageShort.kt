package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageShort (
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("categories")
    val categories: List<Category>,
    @Expose
    @SerializedName("breeds")
    val breeds: List<Breed>
)