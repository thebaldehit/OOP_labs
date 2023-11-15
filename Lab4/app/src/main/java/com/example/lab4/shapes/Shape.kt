package com.example.lab4.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
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

    open fun onDraw(canvas: Canvas, paint: Paint) {
        setDefaultPaint(paint)
    }

    open fun setCords(x: Float, y: Float) {
        endX = x
        endY = y
    }

    fun setAllCords(xs: Float, ys: Float, xe: Float, ye: Float) {
        startX = xs
        startY = ys
        endX = xe
        endY = ye
    }

    open fun setIsDrawing(drawing: Boolean) {
        isDrawing = drawing
    }

    private fun setDefaultPaint(paint: Paint) {
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        paint.pathEffect = DashPathEffect(floatArrayOf(20f, 20f), 0f)
    }
}