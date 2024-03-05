package com.example.retrofit62

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit62.databinding.ActivityMainBinding
import com.example.retrofit62.models.MarvelData
import com.example.retrofit62.modelsUser.ReqUserCreator
import com.example.retrofit62.modelsUser.User
import com.example.retrofit62.networking.ApiClient
import com.example.retrofit62.networking.ApiServise
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//      retrofitBuild()

//      getUsers()

//        getSingleUSer()

//        getUserCreator()

        getUserUpdate()
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

    fun okhttpBuild() {
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

    fun getUsers() {
        val apiservise = ApiClient.getRetrofit().create(ApiServise::class.java)

        apiservise.getUsers(2)
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.d("MainActivity", "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("MainActivity", "onFailure: ${t.message}")
                }
            })
    }

    fun getSingleUSer() {
        val apiservise = ApiClient.getRetrofit().create(ApiServise::class.java)

        apiservise.getSingleUser(1)
            .enqueue(object : Callback<com.example.retrofit62.modelsUser.singleUSer.SingleUser> {
                override fun onResponse(
                    call: Call<com.example.retrofit62.modelsUser.singleUSer.SingleUser>,
                    response: Response<com.example.retrofit62.modelsUser.singleUSer.SingleUser>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.d("MainActivity", "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(
                    call: Call<com.example.retrofit62.modelsUser.singleUSer.SingleUser>,
                    t: Throwable
                ) {
                    Log.d("MainActivity", "onFailure: ${t.message}")
                }
            })
    }

    fun getUserCreator() {
        val apiservise = ApiClient.getRetrofit().create(ApiServise::class.java)

        apiservise.createUser(
            ReqUserCreator("morpheus", "leader")
        )
            .enqueue(object : Callback<com.example.retrofit62.modelsUser.ResUserCreate> {
                override fun onResponse(
                    call: Call<com.example.retrofit62.modelsUser.ResUserCreate>,
                    response: Response<com.example.retrofit62.modelsUser.ResUserCreate>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.d("MainActivity", "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(
                    call: Call<com.example.retrofit62.modelsUser.ResUserCreate>,
                    t: Throwable
                ) {
                    Log.d("MainActivity", "onFailure: ${t.message}")
                }
            })
    }

    fun getUserUpdate(){
        val apiservise = ApiClient.getRetrofit().create(ApiServise::class.java)

        apiservise.updateUser(2, ReqUserCreator("morpheus", "zion resident"))
            .enqueue(object : Callback<com.example.retrofit62.modelsUser.ResUserUpdate> {
                override fun onResponse(
                    call: Call<com.example.retrofit62.modelsUser.ResUserUpdate>,
                    response: Response<com.example.retrofit62.modelsUser.ResUserUpdate>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.d("MainActivity", "onResponse: ${response.body()}")
                    }
                }

                override fun onFailure(
                    call: Call<com.example.retrofit62.modelsUser.ResUserUpdate>,
                    t: Throwable
                ) {
                    Log.d("MainActivity", "onFailure: ${t.message}")
                }
            })

    }
}