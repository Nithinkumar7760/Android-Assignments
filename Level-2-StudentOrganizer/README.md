# Student Organizer App — Level 2 Assignment

**Student Name:** Nithin Kumar M  
**Student ID (USN):** PES1UG25CS829  
**Course:** Android Development  
**Technology Stack:** Android, Kotlin, Jetpack Compose, Material 3, Navigation Compose  

---

## 📌 Project Overview
The **Student Organizer App** is a modern Android application built using **Jetpack Compose** and **Material 3**. It is structured following clean UI architecture principles, declarative UI layouts, reusable component encapsulation, form input state management, and multi-screen navigation using the Jetpack Navigation component.

---

## 🚀 Key Features & Screens

### 1. Dashboard Screen (`dashboard`)
- **Header:** Personalized greeting banner (`Welcome back, Nithin Kumar M!`).
- **Quick Stats:** Overview cards for active courses and pending assignments.
- **Active Courses:** Horizontally scrollable row (`LazyRow`) rendering modular `CourseInfo` cards with progress bars and instructor details.
- **Urgent Deadlines:** Priority-sorted upcoming tasks using `AssignmentCard` components.
- **Floating Action Button (FAB):** Direct shortcut to create new assignments.

### 2. Assignments List Screen (`assignments`)
- **Status Filter:** Filter tasks by `All`, `Pending`, or `Completed` status using interactive RadioButtons.
- **Interactive List:** Efficient `LazyColumn` showing assignments with priority color badges (`Low`, `Medium`, `High`) and real-time completion checkboxes.
- **Action FAB:** Bottom-anchored '+' button navigating to the Add Assignment screen.

### 3. Student Profile Screen (`profile`)
- **Profile Header:** Custom `StudentProfile` composable displaying the student's avatar, name, USN, and department.
- **Academic Metrics:** Visual display of current GPA (3.82), completed credits (84), and current semester (Fall 2026).
- **Quick Actions:** Quick button triggers for profile actions and academic summaries.

### 4. Settings Screen (`settings`)
- **Appearance:** Dynamic Dark Mode toggle using Material 3 `Switch`.
- **Notifications:** Push notifications toggle using `Checkbox`.
- **Startup Preferences:** `RadioButton` selector to customize default landing screen (`Dashboard` vs `Assignments`).

### 5. Add Assignment Screen (`add_assignment`)
- **Top App Bar:** Back navigation arrow to return to caller.
- **Form State Hoisting:** Managed with `remember` and `mutableStateOf`.
- **Form Fields:**
  - Single-line title input (`OutlinedTextField`).
  - Course selection (`OutlinedTextField`).
  - Due date picker field with calendar trailing icon.
  - Priority selector row (`Low`, `Medium`, `High`).
  - Multi-line description field.
  - Reminder notification checkbox.
- **Form Validation:** The "Save Assignment" action button remains disabled until all mandatory fields (Title, Course, and Due Date) are populated.

---

## 🧱 Architecture & Custom Composables

- **`AppBar`**: Top app bar with dynamic titles and contextual back navigation.
- **`BottomBar`**: Material 3 NavigationBar configured with 4 core tabs (Dashboard, Assignments, Profile, Settings).
- **`CourseInfo`**: Reusable card component showcasing course code, instructor, and completion progress.
- **`AssignmentCard`**: Interactive assignment item with status toggle callback and priority styling.
- **`StudentProfile`**: Modular student details and avatar header.
- **`AssignmentForm`**: State-hoisted, reusable input form with validation logic.

---

## 🛠️ Build & Installation

### Requirements
- Android Studio Ladybug / Meerkat or newer
- JDK 17+ (Android Studio bundled JBR)
- Android SDK 34 / 35 (Android 14 / 15)

### Running Locally
1. Clone the repository:
   ```bash
   git clone https://github.com/Nithinkumar7760/Android-Assignments.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle and run on an Android Device or Emulator.
