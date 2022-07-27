package com.example.android_c1.pj_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_c1.R
import com.example.android_c1.pj_2.project2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var id_linearlayout = findViewById<LinearLayout>(R.id.id_linearlayout)
        var text_view = findViewById<TextView>(R.id.tv_textview)
        var btn_purple = findViewById<Button>(R.id.btn_purple)
        var btn_red = findViewById<Button>(R.id.btn_red)
        var btn_blue = findViewById<Button>(R.id.btn_blue)
        var btn_green = findViewById<Button>(R.id.btn_white)
        var next_project=findViewById<Button>(R.id.project_2)




        btn_purple.setOnClickListener {
            make_toast(text_view, "Purple")
            id_linearlayout.setBackgroundColor(resources.getColor(R.color.purple))

        }
        btn_red.setOnClickListener {
            make_toast(text_view, "Red")
            id_linearlayout.setBackgroundColor(resources.getColor(R.color.red))

        }
        btn_blue.setOnClickListener {
            make_toast(text_view, "Blue")
            id_linearlayout.setBackgroundColor(resources.getColor(R.color.blue))

        }
        btn_green.setOnClickListener {
            make_toast(text_view, "Green")
            id_linearlayout.setBackgroundColor(resources.getColor(R.color.green))

        }

        next_project.setOnClickListener {
            var i=Intent(this, project2::class.java)
            startActivity(i)
        }


    }


    fun make_toast(text_view: TextView, text: String) {
        Toast.makeText(this, "Button  $text", Toast.LENGTH_SHORT).show()
        text_view.text = "$text"


    }


}