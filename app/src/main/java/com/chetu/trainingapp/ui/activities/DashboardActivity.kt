package com.chetu.trainingapp.ui.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chetu.trainingapp.R
import com.chetu.trainingapp.adapters.MyRecyclerViewAdapter
import com.chetu.trainingapp.base.BaseActivity
import com.chetu.trainingapp.data.VehicleData
import com.chetu.trainingapp.databinding.ActivityDashboardBinding

class DashboardActivity : BaseActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var recyclerViewAdapter: MyRecyclerViewAdapter
    private var vehicleData: MutableList<VehicleData> = mutableListOf()

    private val email:String = "E-mail Id:  "
    private val password:String = "Password:  "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvEmail.text = email.plus(intent.getStringExtra("email"))
        binding.tvPassword.text = password.plus(intent.getStringExtra("password"))

        vehicleData.add(VehicleData(R.drawable.car1,"Vehicle 1",100))
        vehicleData.add(VehicleData(R.drawable.car2,"Vehicle 2",200))
        vehicleData.add(VehicleData(R.drawable.car3,"Vehicle 3",300))
        vehicleData.add(VehicleData(R.drawable.car4,"Vehicle 4",400))
        vehicleData.add(VehicleData(R.drawable.car1,"Vehicle 1",100))
        vehicleData.add(VehicleData(R.drawable.car2,"Vehicle 2",200))
        vehicleData.add(VehicleData(R.drawable.car3,"Vehicle 3",300))
        vehicleData.add(VehicleData(R.drawable.car4,"Vehicle 4",400))

        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewAdapter = MyRecyclerViewAdapter(this, vehicleData)
        binding.recycler.adapter = recyclerViewAdapter
    }
}