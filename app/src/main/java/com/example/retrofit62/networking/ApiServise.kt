package com.example.retrofit62.networking

import com.example.retrofit62.models.MarvelData
import com.example.retrofit62.modelsUser.ReqUserCreator
import com.example.retrofit62.modelsUser.ResUserCreate
import com.example.retrofit62.modelsUser.ResUserUpdate
import com.example.retrofit62.modelsUser.singleUSer.SingleUser
import com.example.retrofit62.modelsUser.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServise {

    @GET("/demos/marvel/")
    fun getMarvels(): Call<List<MarvelData>>


    @GET("/api/users/")
    fun getUsers(@Query("page") page: Int): Call<User>

    @GET("/api/users/{id}")
    fun getSingleUser(@Path("id") id: Int): Call<SingleUser>

    @POST("/api/users")
    fun createUser(@Body reqUserCreator: ReqUserCreator): Call<ResUserCreate>

    @PUT("/api/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body reqUserCreator: ReqUserCreator): Call<ResUserUpdate>
}