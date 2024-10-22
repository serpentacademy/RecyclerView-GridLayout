package xyz.quantumcompass.androidrecyclergrid

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve data passed from MainActivity
        val courseName = intent.getStringExtra("courseName")
        val position = intent.getIntExtra("position", -1) // Default to -1 if no data

        // Find views by ID and set the data
        val courseTextView: TextView = findViewById(R.id.textViewCourseName)
        val positionTextView: TextView = findViewById(R.id.textViewPosition)

        courseTextView.text = courseName
        positionTextView.text = "Position: $position"
    }
}
