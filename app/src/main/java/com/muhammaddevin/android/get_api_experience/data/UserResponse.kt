package com.muhammaddevin.android.get_api_experience.data

import com.google.gson.annotations.SerializedName


data class UserResponseItem(

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
