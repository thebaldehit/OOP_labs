package com.example.lab5

import android.content.Context
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class Table(private val context: Context, private val tableLayout: TableLayout) {

    fun addRow(color: Int, vararg cellTexts: String) {
        val tableRow = TableRow(context)
        for (text in cellTexts) {
            val textView = TextView(context)
            textView.text = text
            val params = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 10f)
            textView.layoutParams = params
            textView.gravity = Gravity.CENTER
            val background = ShapeDrawable(RectShape())
            background.paint.color = color
            tableRow.background = background
            tableRow.addView(textView)
        }
        tableLayout.addView(tableRow)
    }
}