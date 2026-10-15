package com.pes.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pes.myapplication.components.AppBar
import com.pes.myapplication.components.BottomBar
import com.pes.myapplication.model.Assignment
import com.pes.myapplication.model.sampleAssignments
import com.pes.myapplication.model.sampleCourses
import com.pes.myapplication.model.sampleStudent
import com.pes.myapplication.navigation.Screen
import com.pes.myapplication.screens.AddAssignmentScreen
import com.pes.myapplication.screens.AssignmentsScreen
import com.pes.myapplication.screens.DashboardScreen
import com.pes.myapplication.screens.ProfileScreen
import com.pes.myapplication.screens.SettingsScreen
import com.pes.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                StudentOrganizerApp()
            }
        }
    }
}

/**
 * Root composable for the Student Organizer app.
 * Manages shared state (assignments list) and wires up navigation across all 5 screens.
 */
@Composable
fun StudentOrganizerApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Shared mutable assignment list — adding/toggling is reflected across all screens
    var assignments by remember { mutableStateOf(sampleAssignments) }

    // Determine if we should show bottom bar (hide on AddAssignment screen)
    val showBottomBar = currentRoute != Screen.AddAssignment.route

    // Determine if current screen can navigate back
    val canNavigateBack = currentRoute == Screen.AddAssignment.route

    // Get the title for the current screen
    val currentTitle = when (currentRoute) {
        Screen.Dashboard.route -> Screen.Dashboard.title
        Screen.Assignments.route -> Screen.Assignments.title
        Screen.Profile.route -> Screen.Profile.title
        Screen.Settings.route -> Screen.Settings.title
        Screen.AddAssignment.route -> Screen.AddAssignment.title
        else -> Screen.Dashboard.title
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppBar(
                title = currentTitle,
                canNavigateBack = canNavigateBack,
                onBackClick = { navController.popBackStack() }
            )
        },
        bottomBar = {
            if (showBottomBar) {
                BottomBar(
                    navController = navController,
                    currentRoute = currentRoute
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Dashboard.route
        ) {
            composable(Screen.Dashboard.route) {
                DashboardScreen(
                    studentName = sampleStudent.name,
                    courses = sampleCourses,
                    assignments = assignments,
                    onToggleAssignment = { id ->
                        assignments = assignments.map {
                            if (it.id == id) it.copy(isCompleted = !it.isCompleted) else it
                        }
                    },
                    onAddAssignmentClick = {
                        navController.navigate(Screen.AddAssignment.route)
                    },
                    contentPadding = innerPadding
                )
            }

            composable(Screen.Assignments.route) {
                AssignmentsScreen(
                    assignments = assignments,
                    onToggleAssignment = { id ->
                        assignments = assignments.map {
                            if (it.id == id) it.copy(isCompleted = !it.isCompleted) else it
                        }
                    },
                    onAddAssignmentClick = {
                        navController.navigate(Screen.AddAssignment.route)
                    },
                    contentPadding = innerPadding
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen(
                    student = sampleStudent,
                    contentPadding = innerPadding
                )
            }

            composable(Screen.Settings.route) {
                SettingsScreen(
                    contentPadding = innerPadding
                )
            }

            composable(Screen.AddAssignment.route) {
                AddAssignmentScreen(
                    onSave = { newAssignment: Assignment ->
                        assignments = assignments + newAssignment
                        navController.popBackStack()
                    },
                    onCancel = {
                        navController.popBackStack()
                    },
                    nextId = (assignments.maxOfOrNull { it.id } ?: 0) + 1,
                    contentPadding = innerPadding
                )
            }
        }
    }
}