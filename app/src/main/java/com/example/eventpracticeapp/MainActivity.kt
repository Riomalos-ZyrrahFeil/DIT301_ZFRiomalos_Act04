package com.example.eventpracticeapp

import android.os.Bundle
import android.widget.Button // Import added
import android.widget.EditText // Import added
import android.widget.TextView // Import added
import android.widget.Toast // Import added
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // Views are created here

        // 1. Corrected: View initialization moved AFTER setContentView()
        val nameField = findViewById<EditText>(R.id.edit_name)
        val ageField = findViewById<EditText>(R.id.edit_age)
        val submitButton = findViewById<Button>(R.id.btn_submit)
        val outputText = findViewById<TextView>(R.id.text_output)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Implement event handling: setOnClickListener() [cite: 602]
        submitButton.setOnClickListener {

            val name = nameField.text.toString().trim()
            val ageText = ageField.text.toString().trim()

            // 2. Validate for Empty Fields [cite: 604]
            if (name.isEmpty() || ageText.isEmpty()) {
                // Show Toast message for empty fields [cite: 605, 584]
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()

                // Provide field-specific feedback (Best Practice)
                if (name.isEmpty()) nameField.error = "Name is required"
                if (ageText.isEmpty()) ageField.error = "Age is required"

                // Stop execution
                return@setOnClickListener
            }

            // 3. Implement Error Handling using try-catch for age (non-numeric) [cite: 606, 501]
            try {
                val age = ageText.toInt()

                // Success: Display the result [cite: 603]
                val message = "Hello, $name! You are $age years old."
                outputText.text = message

                // Show success Toast (Instant Feedback) [cite: 608]
                Toast.makeText(this, "Data Submitted!", Toast.LENGTH_SHORT).show()

            } catch (_: NumberFormatException) {
                // Handle invalid input gracefully (Runtime Error) [cite: 521, 522]

                // Show EditText error and user-friendly Toast (Feedback/Error Handling) [cite: 502, 537]
                ageField.error = "Please enter a valid number for age."
                Toast.makeText(this, "Error: Age must be a number.", Toast.LENGTH_LONG).show()

                // Reset output
                outputText.text = getString(R.string.error_invalid_age)
            }
        }
    }
}