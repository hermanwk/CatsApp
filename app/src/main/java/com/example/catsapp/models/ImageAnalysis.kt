package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageAnalysis (
    @Expose
    @SerializedName("image_id")
    val imageId: String,
    @Expose
    @SerializedName("labels")
    val labels: List<String>,
    @Expose
    @SerializedName("moderation_labels")
    val moderationLabels: List<String>,
    @Expose
    @SerializedName("vendor")
    val vendor: String,
    @Expose
    @SerializedName("approved")
    val approved: Boolean,
    @Expose
    @SerializedName("rejected")
    val rejected: Boolean
)