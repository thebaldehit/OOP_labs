package com.example.lab4.editors

import com.example.lab4.shapes.DotShape
import com.example.lab4.shapes.Shape

class DotEditor : Editor() {
    override fun onLeftButtonDown(x: Float, y: Float, callback: (shape: Shape) -> Unit) {
        shape = DotShape(x, y)
        super.onLeftButtonDown(x, y, callback)
    }
}