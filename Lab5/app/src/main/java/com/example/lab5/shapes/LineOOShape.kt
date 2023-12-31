package com.example.lab5.shapes

import android.graphics.Canvas
import android.graphics.Paint

class LineOOShape (x: Float, y: Float) : Shape(x, y) {
    override val name = "Гантеля"

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

    override fun getCords(): FloatArray {
        return line.getCords()
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

    override fun setColorDefault(color: Int) {
        line.setColorDefault(color)
        ellipseOne.setColorDefault(color)
        ellipseTwo.setColorDefault(color)
    }
}