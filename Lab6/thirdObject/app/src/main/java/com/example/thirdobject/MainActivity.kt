package com.example.thirdobject

import android.content.ClipboardManager
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.example.thirdobject.databinding.ActivityMainBinding
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.YAxis
import java.util.Objects


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val item = Objects.requireNonNull(clipboard.primaryClip)?.getItemAt(0)

            val description = Description()
            description.text = "Data"
            binding.lineChart.description = description


            val deserializedData = item?.text?.split(" ")

            val entries1 = ArrayList<Entry>()
            for (index in deserializedData!!.indices) {
                entries1.add(Entry(index.toFloat(), deserializedData[index].toFloat()))
            }

            val dataset = LineDataSet(entries1, "Our data")
            dataset.setColor(Color.BLUE)

            val xAxis: XAxis = binding.lineChart.xAxis
            val yAxis: YAxis = binding.lineChart.axisLeft

            xAxis.position = XAxis.XAxisPosition.BOTTOM
            yAxis.axisMinimum = 0f
            yAxis.setDrawGridLines(true)
            yAxis.setDrawAxisLine(true)

            val lineData = LineData(dataset)

            binding.lineChart.data = lineData
            binding.lineChart.invalidate()
        }
    }
}