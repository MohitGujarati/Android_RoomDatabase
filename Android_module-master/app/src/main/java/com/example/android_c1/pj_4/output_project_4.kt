package com.example.android_c1.pj_4

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_c1.R

class output_project_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_project4)

        var sub4_email = findViewById<TextView>(R.id.sub4_email)
        var sub4_pass = findViewById<TextView>(R.id.sub4_pass)
        var btn_4 = findViewById<Button>(R.id.btn_4)
        var toast_container = findViewById<LinearLayout>(R.id.toast_container)


        var intent = getIntent().extras
        sub4_email.text = intent!!.getString("keyemail")
        sub4_pass.text = intent!!.getString("keypassword")
        Log.d("mydata", "email-" + intent!!.getString("keyemail"))


        val layout = layoutInflater.inflate(R.layout.toastlayout, toast_container)




        btn_4.setOnClickListener {
            var tost = Toast(applicationContext)
            tost.duration = Toast.LENGTH_LONG
            tost.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            tost.view = layout
            tost.show()

        }

        var layout2 = findViewById<LinearLayout>(R.id.ll1)
        var text = TextView(this)
        text.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        text.text = "hello  world"
        text.setTextSize(20f)
        text.setTextColor(Color.BLUE)
        layout2.addView(text)

    }
}
