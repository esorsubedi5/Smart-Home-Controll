package com.example.smarthomecontroll.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Always navigate to LoginActivity
        startActivity(Intent(this, LoginActivity::class.java))
        finish() // Call finish() to remove MainActivity from the back stack
    }
}
