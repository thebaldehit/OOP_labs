package com.example.lab4.editors

import com.example.lab4.shapes.EllipseShape
import com.example.lab4.shapes.Shape

class EllipseEditor : Editor() {
    override fun onLeftButtonDown(x: Float, y: Float, callback: (shape: Shape) -> Unit) {
        shape = EllipseShape(x, y)
        super.onLeftButtonDown(x, y, callback)
    }

    override fun onMouseMove(x: Float, y: Float) {
        shape?.setCords(x, y)
    }

    override fun onLeftButtonUp(x: Float, y: Float) {
        shape?.setCords(x, y)
        shape?.setIsDrawing(false)
    }
}