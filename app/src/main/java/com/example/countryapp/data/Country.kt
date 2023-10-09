package com.example.countryapp.data

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val name: Name,
    @SerializedName("population")
    val currencies: Int,  // decided to change it into population and leave the val name as it is
    val capital: List<String>,
    val area: Double,
    @SerializedName("flags")
    val flag: Flags
    // Add other properties as needed to match your JSON structure
)

data class Name(
    @SerializedName("common")
    val common: String,
    @SerializedName("nativeName")
    val nativeName: Map<String, OfficialCommon>,
    @SerializedName("official")
    val official: String
)

data class OfficialCommon(
    val official: String,
    val common: String
)

data class Currencies(
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)

data class Flags(
    @SerializedName("png")
    val png: String,
    @SerializedName("svg")
    val svg: String,
    @SerializedName("alt")
    val alt: String
)
