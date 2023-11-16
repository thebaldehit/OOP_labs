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

    fun addRow(color: Int, highlightFigure: (idx: Int) -> Unit, vararg cellTexts: String) {
        val rowNumber = tableLayout.childCount
        val tableRow = TableRow(context)

        if (rowNumber !== 0) {
            tableRow.setOnClickListener {
                Log.d("MyTag", "short $rowNumber")
                setDefaultColor(color)
                tableRow.setBackgroundColor(Color.GREEN)
                highlightFigure(rowNumber)
            }
            tableRow.setOnLongClickListener {
                Log.d("MyTag", "long")
                true
            }
        }

        for (text in cellTexts) {
            val textView = TextView(context)
            textView.text = text
            val params = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 10f)
            textView.layoutParams = params
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