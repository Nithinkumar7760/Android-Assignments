package com.pes.myapplication.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Sealed class representing all navigation destinations in the Student Organizer app.
 * Each screen has a unique route string used by the NavHost.
 */
sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector? = null
) {
    data object Dashboard : Screen(
        route = "dashboard",
        title = "Dashboard",
        icon = Icons.Filled.Dashboard
    )

    data object Assignments : Screen(
        route = "assignments",
        title = "Assignments",
        icon = Icons.AutoMirrored.Filled.Assignment
    )

    data object Profile : Screen(
        route = "profile",
        title = "Profile",
        icon = Icons.Filled.Person
    )

    data object Settings : Screen(
        route = "settings",
        title = "Settings",
        icon = Icons.Filled.Settings
    )

    data object AddAssignment : Screen(
        route = "add_assignment",
        title = "Add New Assignment"
    )

    companion object {
        /** Bottom navigation items (excludes AddAssignment) */
        val bottomNavItems = listOf(Dashboard, Assignments, Profile, Settings)
    }
}
