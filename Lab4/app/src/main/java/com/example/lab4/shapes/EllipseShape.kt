package com.example.lab4.shapes
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log

class EllipseShape (x: Float, y: Float) : Shape(x, y) {
    private var centerX = x
    private var centerY = y

    override fun onDraw(canvas: Canvas, paint: Paint) {
        super.onDraw(canvas, paint)
        if (!isDrawing) {
            paint.pathEffect = null
            paint.strokeWidth = 20f
            canvas.drawOval(startX, startY, endX, endY, paint)
            paint.color = Color.rgb(255, 0, 255)
            paint.style = Paint.Style.FILL
        }
        canvas.drawOval(startX, startY, endX, endY, paint)
    }

    override fun setCords(x: Float, y: Float) {
        val deltaX = Math.abs(x - centerX)
        val deltaY = Math.abs(y - centerY)
        startX = centerX - deltaX
        startY = centerY - deltaY
        endX = centerX + deltaX
        endY = centerY + deltaY
    }

    fun setCenterCords(x: Float, y: Float) {
        centerX = x
        centerY = y
    }
}