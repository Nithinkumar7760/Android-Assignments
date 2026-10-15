package com.pes.myapplication.model

/**
 * Data class representing a student's profile information.
 *
 * @param name Full name of the student
 * @param studentId Student identification number
 * @param major Student's declared major
 * @param gpa Current grade point average
 * @param completedCredits Number of credits completed
 * @param currentSemester Current semester label
 */
data class Student(
    val name: String,
    val studentId: String,
    val major: String,
    val gpa: Double,
    val completedCredits: Int,
    val currentSemester: String
)

/** Pre-populated sample student for the app */
val sampleStudent = Student(
    name = "Nithin Kumar M",
    studentId = "PES1UG25CS829",
    major = "Computer Science",
    gpa = 3.82,
    completedCredits = 84,
    currentSemester = "Fall 2026"
)
