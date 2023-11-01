package com.example.lab4.constance

import com.example.lab4.shapes.DotShape
import com.example.lab4.shapes.EllipseShape
import com.example.lab4.shapes.LineShape
import com.example.lab4.shapes.RectangleShape

object Constance {
    val TOOL_CLASSES = mapOf(
        "Крапка" to { x: Float, y: Float -> DotShape(x, y) },
        "Лінія" to { x: Float, y: Float -> LineShape(x, y) },
        "Прямокутник" to { x: Float, y: Float -> RectangleShape(x, y) },
        "Еліпс" to { x: Float, y: Float -> EllipseShape(x, y) },
    )

    const val LIST_MAX_SIZE = 127
}