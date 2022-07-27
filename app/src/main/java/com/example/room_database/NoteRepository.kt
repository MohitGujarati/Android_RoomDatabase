package com.example.room_database

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.room_database.Utils.subscribeOnBackground

class NoteRepository(application: Application)
{
    private lateinit var noteDao : NoteDao
    private lateinit var allNotes : LiveData<List<Note>>

    private  val database = NoteDatabase.getInstance(application)

    init {
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note)
    {
        subscribeOnBackground {
            noteDao.insert(note)
        }
    }
    fun update(note: Note)
    {
        subscribeOnBackground {
            noteDao.update(note)
        }
    }
    fun deleteAllNotes(note:Note)
    {
        subscribeOnBackground {
            noteDao.deleteAllNotes()
        }
    }
    fun getAllNotes():LiveData<List<Note>>{
        return allNotes
    }
}