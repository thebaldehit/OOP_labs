package com.example.lab4

import android.graphics.Canvas
import android.graphics.Paint
import com.example.lab4.constance.Constance
import com.example.lab4.shapes.Shape

class MyEditor {
    private lateinit var currentShapeConstructor : (x: Float, y: Float) -> Shape
    private val shapes = mutableListOf<Shape>()
    private var shape: Shape? = null


    fun setCurrentShapeConstructor(toolClass: (x: Float, y: Float) -> Shape) {
        currentShapeConstructor = toolClass
    }

    private fun addShape(shape: Shape) {
        shapes.add(shape)
        if (shapes.size > Constance.LIST_MAX_SIZE) {
            shapes.removeAt(0)
        }
    }

    fun drawAllFigures(canvas: Canvas, paint: Paint) {
        for (shape in shapes) {
            shape.onDraw(canvas, paint)
        }
    }

    fun onLeftButtonDown(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        val curShape = currentShapeConstructor.invoke(x, y)
        addShape(curShape)
        shape = curShape
        return true
    }

    fun onMouseMove(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        shape?.setCords(x, y)
        invalidateCanvas()
        return true
    }

    fun onLeftButtonUp(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        shape?.setCords(x, y)
        shape?.setIsDrawing(false)
        invalidateCanvas()
        shape = null
        return true
    }
}