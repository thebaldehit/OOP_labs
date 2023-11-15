package com.example.lab4.shapes

import android.graphics.Canvas
import android.graphics.Paint

class RectangleShape (x: Float, y: Float) : Shape(x, y) {
    override fun onDraw(canvas: Canvas, paint: Paint) {
        super.onDraw(canvas, paint)
        if (!isDrawing) {
            paint.pathEffect = null
            canvas.drawRect(startX, startY, endX, endY, paint)
        }
        canvas.drawRect(startX, startY, endX, endY, paint)
    }
}