package xyz.quantumcompass.androidrecyclergrid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var courseAdapter: CourseAdapter
    private val courseList = listOf(
        Course(R.drawable.sample_image, "Android + Java + Firebase"),
        Course(R.drawable.sample_image, "Java Foundations"),
        Course(R.drawable.sample_image, "Android"),
        Course(R.drawable.sample_image, "Firebase")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        courseAdapter = CourseAdapter(courseList) { course, position ->
            // Create an intent to open DetailActivity
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("courseName", course.name)  // Pass the course name
                putExtra("position", position)       // Pass the position
            }
            startActivity(intent)
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns
        recyclerView.adapter = courseAdapter
    }
}
