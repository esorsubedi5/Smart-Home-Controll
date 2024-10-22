package com.example.smarthomecontroll.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smarthomecontroll.databinding.ActivityDashboardBinding
import com.example.smarthomecontroll.adapter.DashboardAdapter
import com.example.smarthomecontroll.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe the dashboard data
        dashboardViewModel.dashboardData.observe(this, Observer { response ->
            if (response != null) {
                val adapter = DashboardAdapter(response.devices, response.recentActivities)
                binding.recyclerView.adapter = adapter
            }
        })

        // Optionally, fetch the dashboard data (e.g., with a token)
        dashboardViewModel.fetchDashboardData("your-auth-token")
    }
}
