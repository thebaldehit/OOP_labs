package com.example.thirdobject

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.thirdobject.databinding.ActivityMainBinding
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
            binding.text.text = item?.text
        }
    }
}