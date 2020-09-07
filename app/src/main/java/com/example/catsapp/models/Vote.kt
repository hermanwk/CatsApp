package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Vote (
    @Expose
    @SerializedName("value")
    val value: Int,
    @Expose
    @SerializedName("image_id")
    val imageId: String,
    @Expose
    @SerializedName("sub_id")
    val subId: String,
    @Expose
    @SerializedName("created_at")
    val createdAt: String,
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("country_code")
    val countryCode: String
)

data class VoteRequest (
    @Expose
    @SerializedName("image_id")
    val imageId: String,
    @Expose
    @SerializedName("sub_id")
    val subId: String,
    @SerializedName("value")
    val value: Boolean
)

data class VoteResponse (
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("id")
    val id: Int
)