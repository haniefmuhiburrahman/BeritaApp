package com.hanief.beritaapp.activity

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.hanief.beritaapp.R
import com.hanief.beritaapp.adapter.BeritaAdapter
import com.hanief.beritaapp.model.Berita
import com.hanief.beritaapp.model.ResponseServer
import com.hanief.beritaapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(isConnect()) {

            ConfigNetwork.getRetrofit().getDataBerita().enqueue(object : Callback<ResponseServer> {
                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

                    pgBar.visibility = View.GONE
                    Log.d("error server", t.message)
                }

                override fun onResponse(
                    call: Call<ResponseServer>,
                    response: Response<ResponseServer>
                ) {

                    Log.d("response", response.message())

                    if (response.isSuccessful) {
                        pgBar.visibility = View.GONE

                        val status = response.body()?.status

                        if (status == "ok") {

                            val data = response.body()?.articles

                            showData(data)
                        }
                    }
                }
            })
        } else {

            pgBar.visibility = View.GONE

            Toast.makeText(this, "device tidak connect dengan internet", Toast.LENGTH_SHORT).show()
        }
    }

    fun isConnect() : Boolean {

        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }

    private fun showData(data: ArrayList<Berita>?) {

        listBerita.adapter = BeritaAdapter(data)
    }
}