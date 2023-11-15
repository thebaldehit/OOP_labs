package com.example.lab5.shapes

import android.graphics.Canvas
import android.graphics.Paint

class CubeShape(x: Float, y: Float) : Shape(x, y) {
    private val frontRectangle = RectangleShape(x, y)
    private val backRectangle = RectangleShape(x, y)
    private val lineOne = LineShape(x, y)
    private val lineTwo = LineShape(x, y)
    private val lineThree = LineShape(x, y)
    private val lineFour = LineShape(x, y)

    override fun onDraw(canvas: Canvas, paint: Paint) {
        super.onDraw(canvas, paint)
        frontRectangle.onDraw(canvas, paint)
        backRectangle.onDraw(canvas, paint)
        lineOne.onDraw(canvas, paint)
        lineTwo.onDraw(canvas, paint)
        lineThree.onDraw(canvas, paint)
        lineFour.onDraw(canvas, paint)
    }

    override fun setCords(x: Float, y: Float) {
        val bigger = getBiggerSide(x, y)
        setFrontCubeCords(x, y, bigger)
        setBackCubeCords(x, y, bigger)
        setCordsFirstLine(x, y, bigger)
        setCordsSecondLine(x, y, bigger)
        setCordsThirdLine(x, y, bigger)
        setCordsFourthLine(x, y, bigger)
    }

    override fun setIsDrawing(drawing: Boolean) {
        frontRectangle.setIsDrawing(drawing)
        backRectangle.setIsDrawing(drawing)
        lineOne.setIsDrawing(drawing)
        lineTwo.setIsDrawing(drawing)
        lineThree.setIsDrawing(drawing)
        lineFour.setIsDrawing(drawing)
    }

    private fun setCordsFirstLine(x: Float, y: Float, bigger: Float) {
        lineOne.addCords(bigger * 0.6f, bigger * 0.3f)
    }

    private fun setCordsSecondLine(x: Float, y: Float, bigger: Float) {
        lineTwo.setAllCords(startX + bigger, startY, endX, endY)
        lineTwo.addCords(bigger * 0.6f, bigger * 0.3f)
    }

    private fun setCordsThirdLine(x: Float, y: Float, bigger: Float) {
        lineThree.setAllCords(startX + bigger, startY + bigger, endX, endY)
        lineThree.addCords(bigger * 0.6f, bigger * 0.3f)
    }

    private fun setCordsFourthLine(x: Float, y: Float, bigger: Float) {
        lineFour.setAllCords(startX, startY + bigger, endX, endY)
        lineFour.addCords(bigger * 0.6f, bigger * 0.3f)
    }

    private fun setFrontCubeCords(x: Float, y: Float, bigger: Float) {
        frontRectangle.setCords(startX + bigger, startY + bigger)
    }

    private fun setBackCubeCords(x: Float, y: Float, bigger: Float) {
        backRectangle.setAllCords(startX + bigger * 0.6f, startY - bigger * 0.3f, startX + bigger * 1.6f, startY + bigger * 0.7f)
    }

    private fun getBiggerSide(x: Float, y: Float): Float {
        val deltaX = x - startX
        val deltaY = y - startY
        return if (Math.abs(deltaX) >= Math.abs(deltaY)) deltaX else deltaY
    }
}