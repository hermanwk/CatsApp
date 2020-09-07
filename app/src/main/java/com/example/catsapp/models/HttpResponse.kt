package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HttpResponse (
    @Expose
    @SerializedName("message")
    val message: String
)