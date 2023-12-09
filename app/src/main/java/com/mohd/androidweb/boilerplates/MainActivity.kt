package com.mohd.androidweb.boilerplates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohd.androidweb.boilerplates.databinding.ActivityMainBinding
import com.mohd.androidweb.boilerplates.simple.SimpleExampleActivity
import com.mohd.androidweb.boilerplates.with_client.WithClientAndInterceptorActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simpleRetrofitBtn.setOnClickListener {
            val intent = Intent(this,SimpleExampleActivity::class.java)
            startActivity(intent)
        }

        binding.okhttpInterceptorRetrofitBtn.setOnClickListener {
            val intent = Intent(this,WithClientAndInterceptorActivity::class.java)
            startActivity(intent)
        }
    }
}