package com.example.android_c1.pj_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_c1.R
import com.example.android_c1.pj_3.project_3

class project2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project2)
        Log.d("mytag", "onCreate");


        var ed_email = findViewById<EditText>(R.id.email)
        var tv_onoff = findViewById<android.widget.TextView>(R.id.on_off)
        var ed_password = findViewById<EditText>(R.id.pass)
        var btnSubmit = findViewById<Button>(R.id.submit)
        var btn_project3=findViewById<Button>(R.id.next_project)

/*
    override fun onStart() {
        super.onStart()
        Log.d("mytag","onStart");
    }

    override fun onPause() {
        super.onPause()
        Log.d("mytag","onPause");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mytag","onRestart");
    }

    override fun onResume() {
        super.onResume()
        Log.d("mytag","onResume");
    }

    override fun onStop() {
        super.onStop()
        Log.d("mytag","onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mytag","onDestroy");
    }


     */


        btnSubmit.setOnClickListener {

            Toast.makeText(this, "Email:-"+ed_email.text.toString(), Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Password:-"+ed_password.text.toString(), Toast.LENGTH_SHORT).show()

            Log.d("mytag","Email:"+ed_email.text.toString());
            if (tv_onoff.text == "ON") {

                tv_onoff.text = "OFF"


            } else

                tv_onoff.text = "ON"

        }
        btn_project3.setOnClickListener {
            var i=Intent(this, project_3::class.java)
            startActivity(i)
        }


    }


}