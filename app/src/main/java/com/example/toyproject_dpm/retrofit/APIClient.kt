package com.example.toyproject_dpm.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    private fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://picsum.photos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    fun getUserService(): APIService {
        return getRetrofit().create(APIService::class.java)
    }
}