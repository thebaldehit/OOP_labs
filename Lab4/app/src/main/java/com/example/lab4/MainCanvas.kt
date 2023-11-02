package com.example.lab4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MainCanvas(context: Context, attrs: AttributeSet) : View(context, attrs) {
    lateinit var myEditor: MyEditor
    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        myEditor.drawAllFigures(canvas, paint)
    }

    private fun invalidateCanvas() {
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> { return myEditor.onLeftButtonDown(event.x, event.y) { invalidateCanvas() } }
            MotionEvent.ACTION_MOVE -> { return myEditor.onMouseMove(event.x, event.y) { invalidateCanvas() } }
            MotionEvent.ACTION_UP -> { return myEditor.onLeftButtonUp(event.x, event.y) { invalidateCanvas() } }
        }
        return super.onTouchEvent(event)
    }
}