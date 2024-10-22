package com.example.smarthomecontroll.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthomecontroll.R

class DeviceDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_detail)

        val deviceName = intent.getStringExtra("DEVICE_NAME")
        // Set up UI to show device details based on received data
    }
}
