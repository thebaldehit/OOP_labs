package com.example.lab5

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.Log
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class Table(private val context: Context, private val tableLayout: TableLayout) {

    fun addRow(color: Int, highlightFigure: (idx: Int) -> Unit, deleteFigure: (idx: Int) -> Unit, vararg cellTexts: String) {
        val tableRow = TableRow(context)

        if (tableLayout.childCount != 0) {
            tableRow.setOnClickListener {
                setDefaultColor(color)
                tableRow.setBackgroundColor(Color.GREEN)
                val idx = tableLayout.indexOfChild(tableRow)
                highlightFigure(idx)
            }
            tableRow.setOnLongClickListener {
                val idx = tableLayout.indexOfChild(tableRow)
                tableLayout.removeView(tableRow)
                deleteFigure(idx)
                true
            }
        }

        for (text in cellTexts) {
            val textView = TextView(context)
            textView.text = text
            textView.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 10f)
            textView.gravity = Gravity.CENTER
            tableRow.addView(textView)
        }
        tableRow.setBackgroundColor(color)
        tableLayout.addView(tableRow)
    }

    fun clear() {
        tableLayout.removeAllViews()
    }

    private fun setDefaultColor(color: Int) {
        for (j in 1 until tableLayout.childCount) {
            val row = tableLayout.getChildAt(j) as TableRow
            row.setBackgroundColor(color)
        }
    }
}