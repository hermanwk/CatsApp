package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Fact (
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("text")
    val text: String,
    @Expose
    @SerializedName("language_code")
    val languageCode: String,
    @Expose
    @SerializedName("breed_id")
    val breedId: String
)