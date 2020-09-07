package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Favourite (
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("image_id")
    val imageId: String,
    @Expose
    @SerializedName("sub_id")
    val subId: String,
    // DateTime
    @Expose
    @SerializedName("created_at")
    val createdAt: String
)

data class FavouriteRequest (
    @Expose
    @SerializedName("image_id")
    val imageId: String,
    @Expose
    @SerializedName("sub_id")
    val subId: String
)

data class FavouriteResponse (
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("id")
    val id: Int
)