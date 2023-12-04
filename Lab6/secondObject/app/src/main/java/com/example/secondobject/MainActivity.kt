package com.example.secondobject

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.secondobject.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bNext.setOnClickListener {
            val resultIntent = Intent()
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        val n = intent.getStringExtra("n")
        val Min = intent.getStringExtra("Min")
        val Max = intent.getStringExtra("Max")

        if (n != null && Min != null && Max != null) {
            val numbers = DoubleArray(n.toInt())

            for (i in 0 until n.toInt()) {
                numbers[i] = Random.nextDouble(Min.toDouble(), Max.toDouble())
            }

            val serializedArray = numbers.joinToString(separator = ", ")
            binding.edit.text = serializedArray

            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val textToCopy = numbers.joinToString(separator = " ")
            val clipData = ClipData.newPlainText("label", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
        } else {
            Toast.makeText(this, "Дані не були передані", Toast.LENGTH_SHORT).show()
        }
    }
}