package com.example.room_database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


// Dao : data access object
// which contain four annotations - insert , update ,delete , query for crud operations

@Dao
interface NoteDao
{
    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Query("delete from note_table")
    fun deleteAllNotes()

    @Query("select * from note_table order by priority desc")
    fun getAllNotes(): LiveData<List<Note>>

}