package com.mohd.androidweb.boilerplates.with_client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohd.androidweb.boilerplates.databinding.ActivityWithInterceptorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WithClientAndInterceptorActivity: AppCompatActivity() {

    lateinit var binding: ActivityWithInterceptorBinding

    private val retro = RetrofitHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithInterceptorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiCall()
    }

    private fun apiCall() {
        val hashMap = HashMap<String,String>()
        hashMap.put("limit","4")

        retro.apiService.getProducts(hashMap).enqueue(object: Callback<List<DataModel>>{
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                if (response.isSuccessful)
                    if (response.code() > 201 && response.code() >= 400) {
                        return
                    } else {
                        binding.resultTv.text = response.body()?.get(0)?.toString()
                    }
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                binding.resultTv.text = t.message
            }
        })
    }
}