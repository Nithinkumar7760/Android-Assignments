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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pes.myapplication.components.AssignmentForm
import com.pes.myapplication.model.Assignment
import com.pes.myapplication.model.Priority

/**
 * Screen 5: Add new assignment form screen with validation.
 * The "Save Assignment" button is disabled until Title, Course, and Due Date are all populated.
 *
 * @param onSave Callback invoked with the new Assignment when "Save" is clicked
 * @param onCancel Callback invoked when "Cancel" is clicked
 * @param nextId The next available assignment ID
 * @param contentPadding Padding values from the parent Scaffold
 */
@Composable
fun AddAssignmentScreen(
    onSave: (Assignment) -> Unit,
    onCancel: () -> Unit,
    nextId: Int,
    contentPadding: PaddingValues
) {
    var title by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("Medium") }
    var description by remember { mutableStateOf("") }
    var reminderEnabled by remember { mutableStateOf(false) }

    // Validation: Save is enabled only when all required fields are populated
    val isSaveEnabled = title.isNotBlank() && course.isNotBlank() && dueDate.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
            .verticalScroll(rememberScrollState())
    ) {
        // Form
        AssignmentForm(
            title = title,
            onTitleChange = { title = it },
            course = course,
            onCourseChange = { course = it },
            dueDate = dueDate,
            onDueDateChange = { dueDate = it },
            priority = priority,
            onPriorityChange = { priority = it },
            description = description,
            onDescriptionChange = { description = it },
            reminderEnabled = reminderEnabled,
            onReminderChange = { reminderEnabled = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Action buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancel")
            }
            Button(
                onClick = {
                    val newAssignment = Assignment(
                        id = nextId,
                        title = title.trim(),
                        course = course.trim(),
                        dueDate = dueDate.trim(),
                        priority = Priority.valueOf(priority),
                        isCompleted = false,
                        description = description.trim(),
                        reminderEnabled = reminderEnabled
                    )
                    onSave(newAssignment)
                },
                enabled = isSaveEnabled,
                modifier = Modifier.weight(1f)
            ) {
                Text("Save Assignment")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}
