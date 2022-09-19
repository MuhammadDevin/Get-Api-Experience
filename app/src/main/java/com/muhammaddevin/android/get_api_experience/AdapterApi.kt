package com.muhammaddevin.android.get_api_experience

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammaddevin.android.get_api_experience.data.UserResponseItem
import com.muhammaddevin.android.get_api_experience.databinding.ItemApiBinding

class AdapterApi: RecyclerView.Adapter<AdapterApi.UserViewHolder>() {
    private val listApi = ArrayList<UserResponseItem>()
    class UserViewHolder(val itemUser: ItemApiBinding): RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemApiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.itemUser.apply {
           with(listApi[position]){
               textView.text = name
               textView2.text = username
               textView3.text = email
           }
       }
    }

    override fun getItemCount() = listApi.size

    fun setUserApi(user: ArrayList<UserResponseItem>){
        this.listApi.clear()
        this.listApi.addAll(user)
    }
}