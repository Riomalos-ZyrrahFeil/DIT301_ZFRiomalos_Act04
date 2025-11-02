# DIT301_ZFRiomalos_Act04

## Activity 4: Event Handling and Input Validation Reflection

### 1. How did you implement event handling for user actions?
Event handling was implemented using the **`setOnClickListener`** method on the `submitButton` object within the `MainActivity.kt`'s `onCreate()` function.

### 2. What techniques ensured smooth and stable interaction?
Stability was ensured through rigorous validation and error handling:
* **Input Validation:** An `if` statement checked for **empty fields**, immediately stopping execution (`return@setOnClickListener`) and providing feedback via a **Toast** and red `error` messages on the specific `EditText` fields.
* **Error Handling:** A **`try-catch`** block was used around the `ageText.toInt()` conversion. This gracefully handles the **`NumberFormatException`** if a non-numeric value is entered, preventing a crash and displaying clear error messages on both the `EditText` and a **Toast**.
* **User Feedback:** **Toast messages** provided instant feedback for both successful submissions and error conditions.

### 3. What improvements would you add in future versions?
1.  **Clear Inputs:** Clear the `EditText` fields upon successful submission to signal completion and prepare the form for a new entry.
2.  **Age Range Validation:** Implement logical validation to ensure the entered age is within a sensible range (e.g., 1 to 120).
3.  **Snackbar:** Replace the success `Toast` with a **Snackbar** for more modern and actionable user feedback.
