package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageFull (
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("sub_id")
    val subId: String,
    @Expose
    @SerializedName("created_at")
    val createdAt: String,
    @Expose
    @SerializedName("original_filename")
    val originalFilename: String,
    @Expose
    @SerializedName("categories")
    val categories: List<Category>,
    @Expose
    @SerializedName("breeds")
    val breeds: List<Breed>
)