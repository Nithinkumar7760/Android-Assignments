package com.pes.myapplication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Reusable assignment form composable with hoisted state.
 * All values and callbacks are passed as parameters for proper state hoisting.
 *
 * @param title Current title value
 * @param onTitleChange Callback when the title changes
 * @param course Current course value
 * @param onCourseChange Callback when the course changes
 * @param dueDate Current due date value
 * @param onDueDateChange Callback when the due date changes
 * @param priority Current priority value
 * @param onPriorityChange Callback when the priority changes
 * @param description Current description value
 * @param onDescriptionChange Callback when the description changes
 * @param reminderEnabled Current reminder state
 * @param onReminderChange Callback when the reminder toggle changes
 */
@Composable
fun AssignmentForm(
    title: String,
    onTitleChange: (String) -> Unit,
    course: String,
    onCourseChange: (String) -> Unit,
    dueDate: String,
    onDueDateChange: (String) -> Unit,
    priority: String,
    onPriorityChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    reminderEnabled: Boolean,
    onReminderChange: (Boolean) -> Unit
) {
    val priorityOptions = listOf("Low", "Medium", "High")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Title field (required)
        OutlinedTextField(
            value = title,
            onValueChange = onTitleChange,
            label = { Text("Assignment Title *") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Course field (required)
        OutlinedTextField(
            value = course,
            onValueChange = onCourseChange,
            label = { Text("Course *") },
            placeholder = { Text("e.g. CS101, MATH201, ENG102") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Due Date field (required) with trailing calendar icon
        OutlinedTextField(
            value = dueDate,
            onValueChange = onDueDateChange,
            label = { Text("Due Date *") },
            placeholder = { Text("e.g. Oct 20, 2026") },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { /* Date picker placeholder */ }) {
                    Icon(
                        imageVector = Icons.Filled.CalendarToday,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        // Priority selection
        Column {
            Text(
                text = "Priority",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectableGroup(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                priorityOptions.forEach { option ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = priority == option,
                                onClick = { onPriorityChange(option) },
                                role = Role.RadioButton
                            )
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = priority == option,
                            onClick = null // Handled by selectable modifier
                        )
                        Text(
                            text = option,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }

        // Description field (optional)
        OutlinedTextField(
            value = description,
            onValueChange = onDescriptionChange,
            label = { Text("Description") },
            minLines = 3,
            maxLines = 5,
            modifier = Modifier.fillMaxWidth()
        )

        // Reminder checkbox
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = reminderEnabled,
                onCheckedChange = onReminderChange
            )
            Text(
                text = "Enable Reminder Notification",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}
