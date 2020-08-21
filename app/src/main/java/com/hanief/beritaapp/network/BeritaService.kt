package com.hanief.beritaapp.network

import com.hanief.beritaapp.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface BeritaService {

    @GET("v2/everything?q=bitcoin&from=2020-07-21&sortBy=publishedAt&apiKey=e296f76504dd4e7caecea047d19505b5")
    fun getDataBerita():Call<ResponseServer>
}