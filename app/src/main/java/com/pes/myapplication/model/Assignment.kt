package com.pes.myapplication.model

/**
 * Enum representing assignment priority levels.
 */
enum class Priority {
    Low,
    Medium,
    High
}

/**
 * Data class representing an assignment in the Student Organizer app.
 *
 * @param id Unique identifier for the assignment
 * @param title Title of the assignment
 * @param course Course code the assignment belongs to (e.g. "CS101")
 * @param dueDate Due date string (e.g. "Oct 20, 2026")
 * @param priority Priority level (Low, Medium, High)
 * @param isCompleted Whether the assignment has been completed
 * @param description Optional description of the assignment
 * @param reminderEnabled Whether a reminder notification is enabled
 */
data class Assignment(
    val id: Int,
    val title: String,
    val course: String,
    val dueDate: String,
    val priority: Priority,
    val isCompleted: Boolean = false,
    val description: String = "",
    val reminderEnabled: Boolean = false
)

/** Pre-populated sample assignments for the app */
val sampleAssignments = listOf(
    Assignment(
        id = 1,
        title = "Binary Search Implementation",
        course = "CS101",
        dueDate = "Oct 18, 2026",
        priority = Priority.High,
        isCompleted = false,
        description = "Implement binary search algorithm in Kotlin with unit tests.",
        reminderEnabled = true
    ),
    Assignment(
        id = 2,
        title = "Integration Problem Set 5",
        course = "MATH201",
        dueDate = "Oct 20, 2026",
        priority = Priority.High,
        isCompleted = false,
        description = "Complete problems 1-15 on integration by parts.",
        reminderEnabled = true
    ),
    Assignment(
        id = 3,
        title = "Essay: Modern Literature",
        course = "ENG102",
        dueDate = "Oct 22, 2026",
        priority = Priority.Medium,
        isCompleted = false,
        description = "Write a 1500-word analytical essay on a modern novel.",
        reminderEnabled = false
    ),
    Assignment(
        id = 4,
        title = "Lab Report: Kinematics",
        course = "PHY101",
        dueDate = "Oct 25, 2026",
        priority = Priority.Medium,
        isCompleted = false,
        description = "Write up findings from the kinematics lab experiment.",
        reminderEnabled = false
    ),
    Assignment(
        id = 5,
        title = "Database Design Project",
        course = "CS101",
        dueDate = "Oct 28, 2026",
        priority = Priority.Low,
        isCompleted = false,
        description = "Design an ER diagram for the student management system.",
        reminderEnabled = false
    ),
    Assignment(
        id = 6,
        title = "Reading Response Ch. 7",
        course = "ENG102",
        dueDate = "Oct 15, 2026",
        priority = Priority.Low,
        isCompleted = true,
        description = "Write a one-page reading response for Chapter 7.",
        reminderEnabled = false
    ),
    Assignment(
        id = 7,
        title = "Calculus Quiz Prep",
        course = "MATH201",
        dueDate = "Oct 14, 2026",
        priority = Priority.High,
        isCompleted = true,
        description = "Review chapters 4-6 for the upcoming quiz.",
        reminderEnabled = false
    )
)
