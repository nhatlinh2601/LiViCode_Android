package com.example.livicode.service

import com.example.livicode.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @GET("todos")
    fun getPosts(): Call<List<Post>>
}