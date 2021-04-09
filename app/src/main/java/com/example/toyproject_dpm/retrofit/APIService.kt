package com.example.toyproject_dpm.retrofit


import com.example.toyproject_dpm.model.ImageList
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("v2/list")
    fun getRequest(): Call<ImageList>
}