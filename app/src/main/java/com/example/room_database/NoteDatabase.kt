package com.example.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.room_database.Utils.subscribeOnBackground

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase:RoomDatabase()
{
    abstract fun noteDao():NoteDao

    companion object{
        private var instance:NoteDatabase?=null

        @Synchronized
        fun getInstance(ctx:Context) : NoteDatabase{
            if(instance == null)
            {
                instance = Room.databaseBuilder(ctx.applicationContext,NoteDatabase::class.java,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build()

            }
            return instance!!
        }

        private val roomCallBack = object  : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                mydb_store(instance!!)
            }
        }

        fun mydb_store(db:NoteDatabase)
        {
            var noteDao = db.noteDao()

            subscribeOnBackground{

                noteDao.insert(Note("my title 1","this is description 1 ",1))
                noteDao.insert(Note("my title 2","this is description 2 ",2))
            }
        }
    }
}