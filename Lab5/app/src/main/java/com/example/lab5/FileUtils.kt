package com.example.lab5

import android.content.Context
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class FileUtils(private val context: Context, private val fileName: String) {

    fun writeFile(data: String) {
        try {
            val outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(outputStream))
            writer.write(data)
            writer.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun appendFile(data: String) {
        try {
            val outputStream = context.openFileOutput(fileName, Context.MODE_APPEND)
            val writer = BufferedWriter(OutputStreamWriter(outputStream))
            writer.write(data)
            writer.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readFile() : String {
        var result = ""
        try {
            val inputStream = context.openFileInput(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String? = reader.readLine()
            while (line != null) {
                result += line
                line = reader.readLine()
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

    fun clearFile() {
        writeFile("")
    }
}