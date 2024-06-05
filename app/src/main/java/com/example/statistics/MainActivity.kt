package com.example.statistics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewCharts: ListView = findViewById(R.id.listView_charts)

        // Define the chart options
        val chartOptions = arrayOf("Pie Chart", "Bar Chart", "Line Chart")

        // Set up ArrayAdapter for the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chartOptions)
        listViewCharts.adapter = adapter

        // Set item click listener for the ListView
        listViewCharts.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    // Navigate to Pie Chart activity
                    startActivity(Intent(this, PieChartActivity::class.java))
                }
                1 -> {
                    // Navigate to Bar Chart activity
                    startActivity(Intent(this, BarChartActivity::class.java))
                }
                2 -> {
                    // Navigate to Line Chart activity
                    startActivity(Intent(this, LineChartActivity::class.java))
                }
            }
        }
    }
}
