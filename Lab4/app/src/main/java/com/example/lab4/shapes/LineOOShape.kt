package com.example.lab4.shapes

import android.graphics.Canvas
import android.graphics.Paint

class LineOOShape (x: Float, y: Float) : Shape(x, y) {
    private val radius = 20f
    private val line = LineShape(x, y)
    private val ellipseOne = EllipseShape(x, y)
    private val ellipseTwo = EllipseShape(x, y)

    init {
        ellipseOne.setCords(x + radius, y + radius)
    }

    override fun onDraw(canvas: Canvas, paint: Paint) {
        line.onDraw(canvas, paint)
        ellipseOne.onDraw(canvas, paint)
        ellipseTwo.onDraw(canvas, paint)
    }

    override fun setCords(x: Float, y: Float) {
        line.setCords(x, y)
        setEllipseLastCords(x, y)
    }

    override fun setIsDrawing(drawing: Boolean) {
        ellipseOne.setIsDrawing(drawing)
        ellipseTwo.setIsDrawing(drawing)
        line.setIsDrawing(drawing)
    }

    private fun setEllipseLastCords(x: Float, y: Float) {
        ellipseTwo.setCenterCords(x, y)
        ellipseTwo.setCords(x + radius, y + radius)
    }
}