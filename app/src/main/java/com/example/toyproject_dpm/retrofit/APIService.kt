package com.example.toyproject_dpm.retrofit

import com.example.toyproject_dpm.model.ImageModel
import retrofit2.Call
import retrofit2.http.GET


data class ResponseDTO(var ImageData: ArrayList<ImageModel>)

interface APIService {

    @GET("v2/list")
    fun getRequest(): Call<ResponseDTO>
}