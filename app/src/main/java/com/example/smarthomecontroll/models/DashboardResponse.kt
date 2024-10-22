package com.example.smarthomecontroll.models

data class DashboardResponse(
    val devices: List<Device>,
    val recentActivities: List<RecentActivity>
)
