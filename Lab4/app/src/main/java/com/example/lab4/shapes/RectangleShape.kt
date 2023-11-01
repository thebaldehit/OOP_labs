package com.example.lab4.shapes
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log

class RectangleShape (x: Float, y: Float) : Shape(x, y) {
    override fun onDraw(canvas: Canvas, paint: Paint) {
        super.onDraw(canvas, paint)
        if (!isDrawing) {
            paint.pathEffect = null
            canvas.drawRect(startX, startY, endX, endY, paint)
            paint.color = Color.BLACK
        }
        canvas.drawRect(startX, startY, endX, endY, paint)
    }
}