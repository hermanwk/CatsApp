package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sponsor (
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("logo_url")
    val logo_url: String
)