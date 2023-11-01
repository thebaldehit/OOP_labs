package com.example.lab4.editors
import com.example.lab4.shapes.LineShape
import com.example.lab4.shapes.Shape

class LineEditor : Editor() {
    override fun onLeftButtonDown(x: Float, y: Float, callback: (shape: Shape) -> Unit) {
        shape = LineShape(x, y)
        super.onLeftButtonDown(x, y, callback)
    }
}