package com.example.jeckpackcomposeactividadclase.network

import com.example.jeckpackcomposeactividadclase.model.Task
import retrofit2.http.GET

interface TaskApi {
    @GET("todos")
    suspend fun getTasks(): List<Task>
}
