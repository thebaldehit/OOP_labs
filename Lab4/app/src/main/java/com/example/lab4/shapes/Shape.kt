package com.example.lab4.shapes
import android.graphics.Canvas
import android.graphics.Paint

open class Shape {
    protected var startX = 0f
    protected var startY = 0f
    protected var endX = 0f
    protected var endY = 0f
    protected var isDrawing: Boolean = true

    constructor(x: Float, y: Float) {
        startX = x
        startY = y
        endX = x
        endY = y
    }

    open fun setCords(x: Float, y: Float) {
        endX = x
        endY = y
    }

    fun setIsDrawing(drawing: Boolean) {
        isDrawing = drawing
    }

    open fun onDraw(canvas: Canvas, paint: Paint) {

    }
}