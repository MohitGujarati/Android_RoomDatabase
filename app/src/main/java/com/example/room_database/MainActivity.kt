package com.example.room_database

import android.app.Notification
import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Bundle
import android.telecom.TelecomManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mohit.dev.roomdbtops.Adapter.NoteAdapter

const val ADD_NOTE_REQUEST= 1
const val EDIT_NOTE_REQUEST= 2

class MainActivity : AppCompatActivity() {
    private lateinit var vm: NoteViewModel
    private lateinit var adapter: NoteAdapter
    private lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        set_recyclerview()

        var fab = findViewById<FloatingActionButton>(R.id.button_add_note)

        fab.setOnClickListener {
            //
        }

        vm = ViewModelProviders.of(this)[NoteViewModel::class.java]

        vm.getAllNotes().observe(this, Observer {
            adapter.submitList(it)
        })


    }

    fun set_recyclerview() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)


        adapter = NoteAdapter { clickedNote ->
            val intent = Intent(this, AddEditActivity::class.java)

            intent.putExtra(NfcAdapter.EXTRA_ID, clickedNote.id)
            intent.putExtra(Notification.EXTRA_TITLE, clickedNote.title)
            intent.putExtra(EXTRA_DESCRIPTION, clickedNote.description)
            intent.putExtra(EXTRA_PRIORITY, clickedNote.priority)
            startActivityForResult(intent,EDIT_NOTE_REQUEST)

        }

        recyclerview.adapter = adapter


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}