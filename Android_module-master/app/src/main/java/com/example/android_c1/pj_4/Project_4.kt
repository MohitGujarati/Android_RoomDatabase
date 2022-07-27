package com.example.android_c1.pj_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.android_c1.R

class project_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project4)

        var btn_submit=findViewById<Button>(R.id.pro4_Submit)
        var pro4_email=findViewById<EditText>(R.id.pro_4_email)
        var pro4_password=findViewById<EditText>(R.id.pro_4_password)


        btn_submit.setOnClickListener {
            var intent = Intent(this,output_project_4::class.java)
            intent.putExtra("keyemail", pro4_email.text.toString())
            intent.putExtra("keypassword", pro4_password.text.toString())
            startActivity(intent)
        }
    }
}