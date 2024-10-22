package com.example.smarthomecontroll.models

data class Device(
    val name: String,
    val type: String, // e.g., Lights, Thermostat
    val status: String // e.g., ON, OFF
)

data class RecentActivity(
    val description: String,
    val timestamp: String
)
