package com.hanief.beritaapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getRetrofit() : BeritaService {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(BeritaService::class.java)

            return service
        }
    }
}