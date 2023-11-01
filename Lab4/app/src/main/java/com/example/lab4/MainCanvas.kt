package com.example.lab4
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MainCanvas(context: Context, attrs: AttributeSet) : View(context, attrs) {
    lateinit var shapeEditor: ShapeEditor
    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        shapeEditor.drawAllFigures(canvas, paint)
    }

    fun invalidateCanvas() {
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> { return shapeEditor.onLeftButtonDown(event.x, event.y) { invalidateCanvas() } }
            MotionEvent.ACTION_MOVE -> { return shapeEditor.onMouseMove(event.x, event.y) { invalidateCanvas() } }
            MotionEvent.ACTION_UP -> { return shapeEditor.onLeftButtonUp(event.x, event.y) { invalidateCanvas() } }
        }
        return super.onTouchEvent(event)
    }
}