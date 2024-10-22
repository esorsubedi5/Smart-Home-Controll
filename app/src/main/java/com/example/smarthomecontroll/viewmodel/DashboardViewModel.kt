package com.example.smarthomecontroll.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smarthomecontroll.api.ApiService
import com.example.smarthomecontroll.models.DashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: ApiService) : ViewModel() {

    private val _dashboardData = MutableLiveData<DashboardResponse>()
    val dashboardData: LiveData<DashboardResponse> get() = _dashboardData

    fun fetchDashboardData(authToken: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboardData(authToken)
                if (response.isSuccessful) {
                    _dashboardData.value = response.body()
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
