package com.example.skycore.utils

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skycore.databinding.AdapterRestaurantBinding
import com.example.skycore.pojo.Restaurant
import kotlin.math.roundToInt

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var restaurants = mutableListOf<Restaurant>()

    @SuppressLint("NotifyDataSetChanged")
    fun setRestaurantList(restaurants: List<Restaurant>) {
        Log.e("TAG", restaurants.toString())
        this.restaurants = restaurants.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRestaurantBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.binding.name.text = restaurant.name
        holder.binding.address.text = "${restaurant.distance.roundToInt()}m, ${(restaurant.location as Map<*, *>)["address1"]}"
        holder.binding.open.text = if (restaurant.isClosed) "Currently CLOSED" else "Currently OPEN"
        holder.binding.rating.text = restaurant.rating.toString()
        Glide.with(holder.itemView.context).load(restaurant.imageUrl).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    inner class MainViewHolder(val binding: AdapterRestaurantBinding) : RecyclerView.ViewHolder(binding.root)

}
