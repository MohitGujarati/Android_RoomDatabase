package com.example.android_c1.pj_3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.android_c1.R
import com.example.android_c1.pj_4.project_4

class project_3 : AppCompatActivity() {

    lateinit var  btn_txt: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project3)

        var btn_web = findViewById<Button>(R.id.openweb)
        var btn_show = findViewById<Button>(R.id.p3_submit)
        var btn_next_4 = findViewById<Button>(R.id.next_project_4)
        var radio_grp = findViewById<RadioGroup>(R.id.radio_grp)


        btn_next_4.setOnClickListener {
            var intent=Intent(this, project_4::class.java)
            startActivity(intent)
        }


        btn_web.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.tops-int.com/"))
            startActivity(intent)
        }


        radio_grp.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.btn_adnroid -> {
                    btn_txt = "Android"
                    btn_show.text = btn_txt

                }
                R.id.btn_kotlin -> {
                    btn_txt = "Kotlin"
                    btn_show.text = btn_txt
                }
                else -> btn_txt = "java"
            }
            btn_show.text = btn_txt
        }


    }
}