package com.bhavanawagh.testapplication

import com.bhavanawagh.testapplication.api.NetworkServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val BASE_URL = "https://dummyjson.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: NetworkServices = retrofit.create(NetworkServices::class.java)

}