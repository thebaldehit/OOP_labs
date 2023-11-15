package com.example.lab5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.lab5.constance.Constance
import com.example.lab5.databinding.ActivityMainBinding
import com.example.lab5.shapes.Shape

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private lateinit var myEditor: MyEditor
    private lateinit var table: Table

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        setSupportActionBar(bindingClass.toolbar)

        table = Table(this, bindingClass.tableLayout)
        table.addRow(Color.CYAN, "Name", "xStart", "yStart", "xEnd", "yEnd")

        myEditor = MyEditor
        myEditor.table = table
        bindingClass.mainCanvas.myEditor = myEditor
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        myEditor.setCurrentShapeConstructor(Constance.TOOL_CLASSES["Крапка"]!!)
        bindingClass.toolbar.title = "Крапка"
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.toString() in Constance.TOOL_CLASSES) {
            val toolClass: (x: Float, y: Float) -> Shape = Constance.TOOL_CLASSES[item.toString()]!!
            myEditor.setCurrentShapeConstructor(toolClass)
            bindingClass.toolbar.title = item.toString()
        } else if (item.toString() == getString(R.string.Clear)) {
            myEditor.deleteAllFigures()
            bindingClass.mainCanvas.invalidateCanvas()
        }
        return super.onOptionsItemSelected(item)
    }
}