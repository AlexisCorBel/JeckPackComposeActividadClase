package com.example.jeckpackcomposeactividadclase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jeckpackcomposeactividadclase.screens.TaskListScreen
import com.example.jeckpackcomposeactividadclase.screens.TaskDetailScreen
import com.example.jeckpackcomposeactividadclase.viewmodel.TaskViewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel: TaskViewModel = viewModel()
                val navController = rememberNavController()
                val tasks = viewModel.tasks.collectAsState().value

                NavHost(navController = navController, startDestination = "list"){
                    composable("list"){
                        TaskListScreen(tasks) { selected ->
                            navController.navigate("detail/${selected.id}")
                        }
                    }

                    composable("detail/{id}"){ backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                        val task = tasks.find { it.id  == id }
                        task?.let {
                            TaskDetailScreen(it) { navController.popBackStack()}
                        }
                    }
                }
            }
        }
    }
}
