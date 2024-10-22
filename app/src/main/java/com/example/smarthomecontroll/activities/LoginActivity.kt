package com.example.smarthomecontroll.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthomecontroll.R
import com.example.smarthomecontroll.models.LoginRequest
import com.example.smarthomecontroll.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Sample login request creation
        val loginRequest = LoginRequest("YourFirstName", "YourStudentID")

        // Specify the location for the login endpoint
        val location = "sydney" // Change this to "footscray" or "ort" as needed

        // Call login method
        loginViewModel.login(location, loginRequest)

        // Observe login response
        loginViewModel.loginResponse.observe(this) { response ->
            response?.let {
                // Handle successful login
                val keypass = it.keypass
                // Navigate to the next screen or perform other actions
                // Navigate to DashboardActivity
                startActivity(Intent(this, DashboardActivity::class.java).apply {
                    putExtra("keypass", keypass) // Pass the keypass to the DashboardActivity
                })
                finish()
            }
        }

        // Observe error response
        loginViewModel.error.observe(this) { errorMessage ->
            errorMessage?.let {
                // Handle error
                // Show error message to the user
            }
        }
    }
}
