package com.example.livicode.viewmodel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.livicode.model.Post
import com.example.livicode.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostViewModel : ViewModel() {
    val posts: MutableLiveData<List<Post>> = MutableLiveData()

    fun fetchPosts() {
        val call: Call<List<Post>> = ApiService.apiService.getPosts()
        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val postList: List<Post>? = response.body()
                    postList?.let {
                        posts.value = it
                    }
                    Log.e("Response",response.toString())

                } else {
                    Log.e("API Error", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                Log.e("API Error", "Error: ${t.message}")
                t.printStackTrace()
            }

        })
    }

}


