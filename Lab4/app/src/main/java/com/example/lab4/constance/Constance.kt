package com.example.lab4.constance

import com.example.lab4.editors.DotEditor
import com.example.lab4.editors.EllipseEditor
import com.example.lab4.editors.LineEditor
import com.example.lab4.editors.RectangleEditor

object Constance {
    val TOOL_CLASSES = mapOf(
        "Крапка" to { DotEditor() },
        "Лінія" to { LineEditor() },
        "Прямокутник" to { RectangleEditor() },
        "Еліпс" to { EllipseEditor() },
    )

    const val LIST_MAX_SIZE = 127
}