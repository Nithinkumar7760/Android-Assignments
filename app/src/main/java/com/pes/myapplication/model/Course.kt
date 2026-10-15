package com.pes.myapplication.model

/**
 * Data class representing a course in the Student Organizer app.
 *
 * @param courseName Full name of the course (e.g. "Introduction to Computer Science")
 * @param courseCode Short course code (e.g. "CS101")
 * @param instructor Name of the instructor
 * @param progress Course completion progress as a Float between 0f and 1f
 */
data class Course(
    val courseName: String,
    val courseCode: String,
    val instructor: String,
    val progress: Float
)

/** Pre-populated sample courses for the app */
val sampleCourses = listOf(
    Course(
        courseName = "Introduction to Computer Science",
        courseCode = "CS101",
        instructor = "Dr. Sarah Chen",
        progress = 0.75f
    ),
    Course(
        courseName = "Calculus II",
        courseCode = "MATH201",
        instructor = "Prof. James Miller",
        progress = 0.60f
    ),
    Course(
        courseName = "English Composition",
        courseCode = "ENG102",
        instructor = "Dr. Emily Watson",
        progress = 0.85f
    ),
    Course(
        courseName = "Physics I",
        courseCode = "PHY101",
        instructor = "Prof. Robert Liu",
        progress = 0.45f
    )
)
