package com.example.countryapp.data

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val name: Name,
    @SerializedName("currencies")
    val currencies: Currencies,
    val capital: List<String>,
    val area: Double,
    val flag: String
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