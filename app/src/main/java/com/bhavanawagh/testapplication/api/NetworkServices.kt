package com.bhavanawagh.testapplication.api

import com.bhavanawagh.testapplication.data.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface NetworkServices {

    @GET("products")
   suspend fun getProducts() : Response<ProductResponse>
}