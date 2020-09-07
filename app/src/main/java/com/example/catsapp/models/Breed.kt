package com.example.catsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Breed (
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("temperament")
    val temperament: String,
    @Expose
    @SerializedName("life_span")
    val lifeSpan: String,
    @Expose
    @SerializedName("alt_names")
    val altNames: String,
    @Expose
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String,
    @Expose
    @SerializedName("origin")
    val origin: String,
    @Expose
    @SerializedName("weight_imperial")
    val weightImperial: String,
    @Expose
    @SerializedName("experimental")
    val experimental: Int,
    @Expose
    @SerializedName("hairless")
    val hairless: Int,
    @Expose
    @SerializedName("natural")
    val natural: Int,
    @Expose
    @SerializedName("rare")
    val rare: Int,
    @Expose
    @SerializedName("rex")
    val rex: Int,
    @Expose
    @SerializedName("suppress_tail")
    val suppressTail: Int,
    @Expose
    @SerializedName("short_legs")
    val shortLegs: Int,
    @Expose
    @SerializedName("hypoallergenic")
    val hypoallergenic: Int,
    @Expose
    @SerializedName("adaptability")
    val adaptability: Int,
    @Expose
    @SerializedName("affection_level")
    val affectionLevel: Int,
    @Expose
    @SerializedName("country_code")
    val countryCode: String,
    @Expose
    @SerializedName("child_friendly")
    val childFriendly: Int,
    @Expose
    @SerializedName("dog_friendly")
    val dogFriendly: Int,
    @Expose
    @SerializedName("energy_level")
    val energyLevel: Int,
    @Expose
    @SerializedName("grooming")
    val grooming: Int,
    @Expose
    @SerializedName("health_issues")
    val healthIssues: Int,
    @Expose
    @SerializedName("intelligence")
    val intelligence: Int,
    @Expose
    @SerializedName("shedding_level")
    val sheddingLevel: Int,
    @Expose
    @SerializedName("social_needs")
    val socialNeeds: Int,
    @Expose
    @SerializedName("stranger_friendly")
    val strangerFriendly: Int,
    @Expose
    @SerializedName("vocalisation")
    val vocalisation: Int
)