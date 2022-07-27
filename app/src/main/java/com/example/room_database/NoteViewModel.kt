package com.example.room_database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel(app:Application) : AndroidViewModel(app) {
    private val repository = NoteRepository(app)
    private val allNotes = repository.getAllNotes()

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun update(note: Note) {
        repository.update(note)
    }

    fun deleteAllNote(note: Note)
    {
        repository.deleteAllNotes(note)
    }
    fun getAllNotes():LiveData<List<Note>>
    {
        return allNotes
    }

}