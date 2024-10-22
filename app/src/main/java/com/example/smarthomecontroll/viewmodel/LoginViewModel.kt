package com.example.smarthomecontroll.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smarthomecontroll.api.ApiService
import com.example.smarthomecontroll.models.LoginRequest
import com.example.smarthomecontroll.models.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    private val _loginResponse = MutableLiveData<LoginResponse?>()
    val loginResponse: LiveData<LoginResponse?> get() = _loginResponse

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun login(location: String, loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                // Call the login method on the injected apiService instance
                val response = apiService.login(location, loginRequest)
                if (response.isSuccessful) {
                    _loginResponse.value = response.body()
                    _error.value = null // Clear any previous error
                } else {
                    _error.value = "Login failed: ${response.message()}"
                    _loginResponse.value = null // Clear any previous response
                }
            } catch (e: HttpException) {
                _error.value = "Login failed: ${e.message()}"
                _loginResponse.value = null // Clear any previous response
            } catch (e: Exception) {
                _error.value = "An error occurred: ${e.localizedMessage}"
                _loginResponse.value = null // Clear any previous response
            }
        }
    }
}
