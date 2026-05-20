package com.example.lab09

import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostModel>
}