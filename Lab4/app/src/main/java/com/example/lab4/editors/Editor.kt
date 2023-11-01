package com.example.lab4.editors

import com.example.lab4.shapes.Shape

open class Editor {
    var shape: Shape? = null

    open fun onLeftButtonDown(x: Float, y: Float, callback: (shape: Shape) -> Unit) {
        callback(shape!!)
    }

    open fun onMouseMove(x: Float, y: Float) {
        shape?.setCords(x, y)
    }

    open fun onLeftButtonUp(x: Float, y: Float) {
        shape?.setCords(x, y)
        shape?.setIsDrawing(false)
    }
}