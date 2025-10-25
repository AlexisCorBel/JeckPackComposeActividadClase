package com.example.jeckpackcomposeactividadclase.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jeckpackcomposeactividadclase.model.Task

@Composable
fun TaskDetailScreen(task: Task, onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Button(onClick = { onBack() }) {
            Text("Regresar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Título: ${task.title}", style = MaterialTheme.typography.titleLarge)
        Text("Completada: ${if(task.completed) "Sí" else "No"}")
    }
}
