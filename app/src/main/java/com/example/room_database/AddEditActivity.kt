package com.example.room_database

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_ID = "EXTRA_ID"
const val EXTRA_TITLE = "EXTRA_ID"
const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"
const val EXTRA_PRIORITY = "EXTRA_PRIORITY"

class AddEditActivity : AppCompatActivity() {


    private lateinit var mode: Mode
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)

        var ed_title=findViewById<EditText>(R.id.ed_title)
        var ed_description=findViewById<EditText>(R.id.ed_description)
        var ed_priority=findViewById<EditText>(R.id.ed_priority)
        var btn_submit=findViewById<Button>(R.id.btn_submit)
    }

    class Mode {
        object AddNote : Mode(f)
        object EditNote : Mode()
    }
}