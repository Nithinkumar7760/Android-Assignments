package com.pes.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pes.myapplication.components.AssignmentCard
import com.pes.myapplication.model.Assignment

/**
 * Screen 2: Assignments list screen with filter chips and FAB.
 *
 * @param assignments List of all assignments
 * @param onToggleAssignment Callback to toggle assignment completion
 * @param onAddAssignmentClick Callback when the FAB is clicked
 * @param contentPadding Padding values from the parent Scaffold
 */
@Composable
fun AssignmentsScreen(
    assignments: List<Assignment>,
    onToggleAssignment: (Int) -> Unit,
    onAddAssignmentClick: () -> Unit,
    contentPadding: PaddingValues
) {
    var selectedFilter by remember { mutableStateOf("All") }
    val filters = listOf("All", "Pending", "Completed")

    val filteredAssignments = when (selectedFilter) {
        "Pending" -> assignments.filter { !it.isCompleted }
        "Completed" -> assignments.filter { it.isCompleted }
        else -> assignments
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddAssignmentClick) {
                Icon(Icons.Filled.Add, contentDescription = "Add assignment")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(innerPadding)
        ) {
            // Header
            Text(
                text = "My Assignments",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )

            // Filter chips row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                filters.forEach { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Assignments list
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(filteredAssignments, key = { it.id }) { assignment ->
                    AssignmentCard(
                        title = assignment.title,
                        course = assignment.course,
                        dueDate = assignment.dueDate,
                        priority = assignment.priority.name,
                        isCompleted = assignment.isCompleted,
                        onToggleComplete = { onToggleAssignment(assignment.id) }
                    )
                }
            }
        }
    }
}
