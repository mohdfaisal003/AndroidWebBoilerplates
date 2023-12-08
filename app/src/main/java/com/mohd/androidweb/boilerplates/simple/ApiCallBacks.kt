package com.mohd.androidweb.boilerplates.simple

import retrofit2.Call
import retrofit2.http.GET

interface ApiCallBacks {

    @GET("random/")
    fun responseCall() : Call<List<DataModel>>
}