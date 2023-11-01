package com.example.lab4.editors
import com.example.lab4.shapes.RectangleShape
import com.example.lab4.shapes.Shape

class RectangleEditor : Editor() {
    override fun onLeftButtonDown(x: Float, y: Float, callback: (shape: Shape) -> Unit) {
        shape = RectangleShape(x, y)
        super.onLeftButtonDown(x, y, callback)
    }
}