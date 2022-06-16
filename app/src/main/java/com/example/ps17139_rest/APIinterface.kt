package com.example.ps17139_rest
import retrofit2.Call
import retrofit2.http.GET
interface APIinterface {
    @get:GET(value="posts")
    val posts: Call<List<post?>?>?
    @get:GET(value="comments")
    val comments: Call<List<comment?>?>?
    companion object{
        const val BASE_URL="https://jsonplaceholder.typicode.com"
    }

}