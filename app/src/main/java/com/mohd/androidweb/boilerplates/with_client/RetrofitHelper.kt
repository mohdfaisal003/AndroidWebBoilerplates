package com.mohd.androidweb.boilerplates.with_client

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class RetrofitHelper {

    private val baseUrl = "https://fakestoreapi.com/"

    /* Created this interceptor to add pre-header | Request checking */
    class NetworkInterceptor(val headerKey: String,val headerValue: String): Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request().newBuilder()
                .addHeader(headerKey,headerValue)
                .build()
            return chain.proceed(request)
        }
    }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(NetworkInterceptor("Content-Type","application/json"))
        .callTimeout(60L,TimeUnit.SECONDS)
        .connectTimeout(60L,TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    val apiService : ApiCallBacks by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCallBacks::class.java)
    }
}