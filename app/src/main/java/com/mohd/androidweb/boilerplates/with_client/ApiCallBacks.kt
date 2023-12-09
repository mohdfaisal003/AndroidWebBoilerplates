package com.mohd.androidweb.boilerplates.with_client

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiCallBacks {

    @GET("products/")
    fun getProducts(@QueryMap limit: HashMap<String,String>): Call<List<DataModel>>
}