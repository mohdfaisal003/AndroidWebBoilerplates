package com.mohd.androidweb.boilerplates.simple

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mohd.androidweb.boilerplates.databinding.ActivitySimpleExampleBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SimpleExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleExampleBinding
    private val retroHelper = RetroHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiCall()
        binding.refreshBtn.setOnClickListener {
            refreshQuote()
        }
    }

    private fun refreshQuote() {
        apiCall()
    }

    private fun apiCall() {
        retroHelper.apiService.responseCall().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                if (response.isSuccessful)
                    if (response.code() > 201 && response.code() >= 400) {
                        return
                    } else {
                        binding.quoteTV.text = response.body()?.get(0)?.q
                    }
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                Log.e("OnFailure",t.message!!)
            }
        })
    }
}