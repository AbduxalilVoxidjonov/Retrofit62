package com.example.retrofit62

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit62.databinding.ActivityMainBinding
import com.example.retrofit62.models.MarvelData
import com.example.retrofit62.networking.ApiClient
import com.example.retrofit62.networking.ApiServise
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        retrofitBuild()



    }

    fun retrofitBuild() {
        val apiservise = ApiClient.getRetrofit().create(ApiServise::class.java)

        apiservise.getMarvels()
            .enqueue(object : Callback<List<MarvelData>> {
                override fun onResponse(
                    call: Call<List<MarvelData>>,
                    response: retrofit2.Response<List<MarvelData>>
                ) {
                    if (response.isSuccessful && response.body() != null) {

                    }
                }

                override fun onFailure(call: Call<List<MarvelData>>, t: Throwable) {

                }
            })
    }

    fun okhttpBuild(){
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            // jsonplasholder.typicode.com/users
            .url("https://jsonplaceholder.typicode.com/users/1")
            .build()

        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: java.io.IOException) {
                Log.d("MainActivity", "onFailure: ${e.message}")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    Log.d("MainActivity", "onResponse: $body")
                }
            }
        })
    }
}