package com.example.aibnotesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlper(context:Context):SQLiteOpenHelper(context, "Mydatabace.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        if(db !=null)
        {
            db.execSQL("create table NotesTable(ID INTEGER PRIMARY KEY,note text)")
        }


    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun addNote(noteModel: Any?): Long {
        val db = this.writableDatabase

        val cv = ContentValues()

       // cv.put(KEY_NOTE, note.noteText)

        val status = db.insert("NotesTable", null, cv)

        db.close()
        return status
    }
    }

