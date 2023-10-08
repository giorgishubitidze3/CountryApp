package com.example.countryapp.network

import com.example.countryapp.data.Country
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("v3.1/region/europe")
    suspend fun getEurope() : List<Country>
    @GET("v3.1/region/asia")
    suspend fun getAsia() : List<Country>
    @GET("v3.1/region/africa")
    suspend fun getAfrica() : List<Country>
    @GET("v3.1/subregion/South%20America")
    suspend fun getSouthAmerica() : List<Country>
    @GET("v3.1/subregion/North%20America")
    suspend fun getNorthAmerica() : List<Country>
    @GET("v3.1/subregion/Australia")
    suspend fun getAustralia() : List<Country>
    @GET("v3.1/region/Antarctic")
    suspend fun getAntarctica() : List<Country>

}