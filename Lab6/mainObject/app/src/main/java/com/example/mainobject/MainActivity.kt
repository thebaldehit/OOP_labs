package com.example.mainobject

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mainobject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            bRun.setOnClickListener {
                if (editN.text.toString() == "" || editMin.text.toString() == "" || editMax.text.toString() == "") {
                    Toast.makeText(this@MainActivity, "Дані не були передані", Toast.LENGTH_SHORT).show()
                } else {
                    val packageName = "com.example.secondobject"
                    val activityClassName = "com.example.secondobject.MainActivity"
                    val componentName = ComponentName(packageName, activityClassName)
                    val intent = Intent().setComponent(componentName)
                    if (packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                        intent.putExtra("n", editN.text.toString())
                        intent.putExtra("Min", editMin.text.toString())
                        intent.putExtra("Max", editMax.text.toString())
                        startActivityForResult(intent, 100)
                    } else {
                        Toast.makeText(this@MainActivity, "Програму не знайдено", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            val packageName = "com.example.thirdobject"
            val activityClassName = "com.example.thirdobject.MainActivity"
            val componentName = ComponentName(packageName, activityClassName)
            val intent = Intent().setComponent(componentName)
            if (packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                startActivityForResult(intent, 200)
            } else {
                Toast.makeText(this@MainActivity, "Програму не знайдено", Toast.LENGTH_SHORT).show()
            }
        } else if (requestCode == 200 && resultCode == RESULT_OK) {
            Log.d("MyTag", "technologia jobana")
        }
    }
}