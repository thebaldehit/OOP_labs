package com.example.lab4.shapes
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class EllipseShape (x: Float, y: Float) : Shape(x, y) {
    private var centerX = x
    private var centerY = y

    override fun onDraw(canvas: Canvas, paint: Paint) {
        super.onDraw(canvas, paint)
        if (!isDrawing) {
            canvas.drawOval(startX, startY, endX, endY, paint)
            paint.pathEffect = null
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
}