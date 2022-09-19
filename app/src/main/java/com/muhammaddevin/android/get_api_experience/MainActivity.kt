package com.muhammaddevin.android.get_api_experience

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammaddevin.android.get_api_experience.data.UserResponseItem
import com.muhammaddevin.android.get_api_experience.databinding.ActivityMainBinding
import com.muhammaddevin.android.get_api_experience.jaringan.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val adapterApi = AdapterApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataApi()

    }

    fun setDataApi(data: ArrayList<UserResponseItem>){
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterApi
            adapterApi.setUserApi(data)
        }
    }

    fun getDataApi(){
        ApiConfig.getApiService().getListUser().enqueue(object : Callback<ArrayList<UserResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<UserResponseItem>>,
                response: Response<ArrayList<UserResponseItem>>
            ) {
                response.body()?.let {
                    setDataApi(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<UserResponseItem>>, t: Throwable) {
                Log.i("TAG", "onFailure: $t", )
            }

        })
    }


}