package com.example.jeckpackcomposeactividadclase.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jeckpackcomposeactividadclase.model.Task
import com.example.jeckpackcomposeactividadclase.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTasks()
                _tasks.value = response
            } catch (e: Exception) {
                Log.e("TaskViewModel", "Error fetching tasks: $e")
            }
        }
    }
}
