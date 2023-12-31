package com.example.lab4.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class DotShape(x: Float, y: Float) : Shape(x, y) {
    override fun onDraw(canvas: Canvas, paint: Paint) {
        super.onDraw(canvas, paint)
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 10f
        canvas.drawPoint(startX, startY, paint)
    }
}