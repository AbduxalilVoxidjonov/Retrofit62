package com.example.retrofit62.networking

import com.example.retrofit62.models.MarvelData
import retrofit2.Call
import retrofit2.http.GET

interface ApiServise {

    @GET("/demos/marvel/")
    fun getMarvels(): Call<List<MarvelData>>

}