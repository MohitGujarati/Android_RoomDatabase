package com.example.room_database

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_ID = "EXTRA_ID"
const val EXTRA_TITLE = "EXTRA_ID"
const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"
const val EXTRA_PRIORITY = "EXTRA_PRIORITY"

class AddEditActivity : AppCompatActivity() {


    private lateinit var mode: Mode

    var noteid=-1
   lateinit var notepicker:NumberPicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)

        var ed_title=findViewById<EditText>(R.id.ed_title)
        var ed_description=findViewById<EditText>(R.id.ed_description)
        var ed_priority=findViewById<NumberPicker>(R.id.ed_priority)
        var btn_submit=findViewById<Button>(R.id.btn_submit)

        ed_priority.minValue=1
        ed_priority.maxValue=10

        noteid=intent.getIntExtra(EXTRA_ID,-1)
        mode=if (noteid==-1)Mode.AddNote
        else Mode.EditNote

        when(mode){
            Mode.AddNote->title="Add Note"

            Mode.EditNote->{
                title="Edit Note"

                ed_title.setText(intent.getStringExtra(EXTRA_TITLE))
                ed_description.setText(intent.getStringExtra(EXTRA_DESCRIPTION))
                ed_priority.value=intent.getIntExtra(EXTRA_PRIORITY,-1)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
      //  menuInflater.inflate(R.menu.menusave)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_submit->{

            }

        }

        if (noteid!=-1){

        }
        return true
    }

    //a class can not be inherited by any class but instantiated
   sealed class Mode {
        object AddNote : Mode()
        object EditNote : Mode()
    }
}