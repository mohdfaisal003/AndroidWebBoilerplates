package com.mohd.androidweb.boilerplates.simple

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroHelper {

    val baseUrl = "https://zenquotes.io/api/"

    val apiService: ApiCallBacks by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCallBacks::class.java)
    }
}