package com.example.lab4

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.lab4.shapes.Shape
import com.example.lab4.constance.Constance
import com.example.lab4.editors.Editor

class ShapeEditor {
    private lateinit var currentEditorConstructor : () -> Editor
    private val shapes = mutableListOf<Shape>()
    private var editor: Editor? = null

    fun setCurrentEditorConstructor(toolClass: () -> Editor) {
        currentEditorConstructor = toolClass
    }

    fun setDefaultPaint(paint: Paint) {
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
//        paint.pathEffect = DashPathEffect(floatArrayOf(30f, 30f), 0f)
    }


    private fun addShape(shape: Shape) {
        shapes.add(shape)
        if (shapes.size > Constance.LIST_MAX_SIZE) {
            shapes.removeAt(0)
        }
    }

    fun drawAllFigures(canvas: Canvas, paint: Paint) {
        for (shape in shapes) {
            setDefaultPaint(paint)
            shape.onDraw(canvas, paint)
        }
    }

    fun onLeftButtonDown(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        editor = currentEditorConstructor.invoke()
        editor?.onLeftButtonDown(x, y) { addShape(it) }
        return true
    }

    fun onMouseMove(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        editor?.onMouseMove(x, y)
        invalidateCanvas()
        return true
    }

    fun onLeftButtonUp(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        editor?.onLeftButtonUp(x, y)
        invalidateCanvas()
        editor = null
        return true
    }
}