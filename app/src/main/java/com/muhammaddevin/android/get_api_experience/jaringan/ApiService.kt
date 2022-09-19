package com.muhammaddevin.android.get_api_experience.jaringan

import com.muhammaddevin.android.get_api_experience.data.UserResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getListUser(): Call<ArrayList<UserResponseItem>>
}