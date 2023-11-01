package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.lab4.constance.Constance
import com.example.lab4.databinding.ActivityMainBinding
import com.example.lab4.editors.Editor

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private lateinit var shapeEditor: ShapeEditor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        setSupportActionBar(bindingClass.toolbar)

        shapeEditor = ShapeEditor()
        bindingClass.mainCanvas.shapeEditor = shapeEditor
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        shapeEditor.setCurrentEditorConstructor(Constance.TOOL_CLASSES["Крапка"]!!)
        bindingClass.toolbar.title = "Крапка"
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.toString() in Constance.TOOL_CLASSES) {
            val toolClass: () -> Editor = Constance.TOOL_CLASSES[item.toString()]!!
            shapeEditor.setCurrentEditorConstructor(toolClass)
            bindingClass.toolbar.title = item.toString()
        }
        return super.onOptionsItemSelected(item)
    }
}