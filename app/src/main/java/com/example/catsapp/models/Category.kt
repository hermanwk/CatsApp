package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category (
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("name")
    val name: String
)

data class CategoryResponse (
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String
)