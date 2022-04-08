package com.chetu.trainingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chetu.trainingapp.data.VehicleData
import com.chetu.trainingapp.databinding.ActivityVehicleBinding

class MyRecyclerViewAdapter(private val context: Context, private val data: MutableList<VehicleData>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    private lateinit var binding: ActivityVehicleBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ActivityVehicleBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        binding.vehicleImage.setImageResource(data[position].vehicleImage)
        binding.vehicleName.text = data[position].vehicleName
        binding.vehiclePrice.text = data[position].vehiclePrice.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}