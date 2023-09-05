package com.example.cryptoinfo.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    //https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD&api_key=b55f2800d9d2c4eec9b9c661cfefd266ca4311b0f6a5974a83865764ebbca618

    private const val BASE_URL = "https://min-api.cryptocompare.com/data/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}