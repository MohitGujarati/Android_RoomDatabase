package com.example.android_c1.pj_6

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.android_c1.R

class project_6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project6)

        var dynamic_data = findViewById<ListView>(R.id.dynamic_data)
        var lv = findViewById<ListView>(R.id.pre_list)
        var edname = findViewById<EditText>(R.id.ed_name)
        var btnadd = findViewById<Button>(R.id.btn_add)
        var idspinner = findViewById<Spinner>(R.id.id_spinner)
        var btnAlert=findViewById<Button>(R.id.btn_Alert)

        //Adding data frome here
        /*
          lv.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, ""+lv.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        }
        var sub= arrayOf("java","python","Android")

        //creating an adapter and adding data of array list in it
        var adapter:ArrayAdapter<*>
        adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,sub)
        lv.adapter=adapter
         */

        //dynamic adding the  data

        var st_name = arrayListOf<String>()
        var adapter: ArrayAdapter<*>

        btnadd.setOnClickListener {
            st_name.add(edname.text.toString())
            edname.text.clear()
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, st_name)
            dynamic_data.adapter = adapter
        }
        dynamic_data.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "" + dynamic_data.getItemAtPosition(position), Toast.LENGTH_SHORT)
                .show()
        }


        idspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    applicationContext,
                    "" + idspinner.getItemAtPosition(position),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        btnAlert.setOnClickListener {
            var builder=AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Do you want to exite")
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show()
                })

                .setNeutralButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                })

            builder.show()
        }

    }
}