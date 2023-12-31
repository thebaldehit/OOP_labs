package com.example.lab5

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.lab5.constance.Constance
import com.example.lab5.shapes.Shape

object MyEditor {
    private lateinit var currentShapeConstructor : (x: Float, y: Float) -> Shape
    private var highlightedShape: Shape? = null
    private val shapes = mutableListOf<Shape>()
    private var shape: Shape? = null

    lateinit var table : Table
    lateinit var fileUtils: FileUtils

    fun setCurrentShapeConstructor(toolClass: (x: Float, y: Float) -> Shape) {
        currentShapeConstructor = toolClass
    }

    private fun addShape(shape: Shape) {
        shapes.add(shape)
        if (shapes.size > Constance.LIST_MAX_SIZE) {
            shapes.removeAt(0)
        }
    }

    fun drawAllShapes(canvas: Canvas, paint: Paint) {
        for (shape in shapes) {
            shape.onDraw(canvas, paint)
        }
    }

    fun deleteAllShapes() {
        shapes.clear()
        fileUtils.clearFile()
    }

    private fun deleteShape(idx: Int, invalidateCanvas: () -> Unit) {
        shapes.removeAt(idx - 1)
        invalidateCanvas()
        fileUtils.clearFile()
        for (shape in shapes) {
            fileUtils.appendFile(serializeShape(shape))
        }
    }

    private fun highlightShapes(idx: Int, invalidateCanvas: () -> Unit) {
        highlightedShape?.setColorDefault(Color.BLACK)
        val highlightShape = shapes[idx - 1]
        highlightShape.setColorDefault(Color.CYAN)
        highlightedShape = highlightShape
        invalidateCanvas()
    }

    private fun serializeShape(shape: Shape) : String {
        val cords = shape.getCords()
        return "${shape.name} ${cords.joinToString(separator = " ")}\n"
    }

    fun uploadShapes(invalidateCanvas: () -> Unit) {
        val dataString = fileUtils.readFile().trimIndent()
        if (dataString != "") {
            val data = dataString.split("\n")
            for (item in data) {
                val shapeData = item.trimIndent().split(" ")
                val createShapeInstance: (x: Float, y: Float) -> Shape = Constance.TOOL_CLASSES[shapeData[0]]!!
                val createdShape = createShapeInstance.invoke(shapeData[1].toFloat(), shapeData[2].toFloat())
                addShape(createdShape)
                createdShape.setCords(shapeData[3].toFloat(), shapeData[4].toFloat())
                createdShape.setIsDrawing(false)
                table.addRow(Color.WHITE, { idx: Int -> highlightShapes(idx, invalidateCanvas) }, { idx: Int -> deleteShape(idx, invalidateCanvas) }, shapeData[0], shapeData[1], shapeData[2], shapeData[3], shapeData[4])
            }
            invalidateCanvas()
        }
    }

    fun onLeftButtonDown(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        val curShape = currentShapeConstructor.invoke(x, y)
        addShape(curShape)
        shape = curShape
        return true
    }

    fun onMouseMove(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        shape?.setCords(x, y)
        invalidateCanvas()
        return true
    }

    fun onLeftButtonUp(x: Float, y: Float, invalidateCanvas: () -> Unit) : Boolean {
        shape?.setCords(x, y)
        shape?.setIsDrawing(false)
        invalidateCanvas()
        val cords = shape?.getCords()
        if (cords != null && cords.isNotEmpty()) {
            table.addRow(Color.WHITE, { idx: Int -> highlightShapes(idx, invalidateCanvas) }, { idx: Int -> deleteShape(idx, invalidateCanvas) }, shape!!.name, cords[0].toString(), cords[1].toString(), cords[2].toString(), cords[3].toString())
        }
        fileUtils.appendFile(serializeShape(shape!!))
        shape = null
        return true
    }
}