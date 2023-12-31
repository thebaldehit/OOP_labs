package com.example.lab5.shapes
import android.graphics.Canvas
import android.graphics.Paint

class LineShape (x: Float, y: Float) : Shape(x, y) {
    override val name = "Лінія"
    override fun onDraw(canvas: Canvas, paint: Paint) {
        super.onDraw(canvas, paint)
        if (!isDrawing) {
            paint.pathEffect = null
        }
        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    fun addCords(deltaX: Float, deltaY: Float) {
        endX = startX + deltaX
        endY = startY - deltaY
    }
}