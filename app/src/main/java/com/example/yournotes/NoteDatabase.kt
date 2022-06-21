package com.example.yournotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
    //NOTE: we always use this technique to make a singleton class
            companion object{

             // Singleton prevents multiple instances of database opening at the
             // same time.
             @Volatile
             private var INSTANCE: NoteDatabase? = null

             fun getDatabase(context: Context): NoteDatabase {
                 // if the INSTANCE is not null, then return it,
                 // if it is, then create the database
                 //synchronized block so that no other thread can access this at that time
                 return INSTANCE ?: synchronized(this) {
                     val instance = Room.databaseBuilder(
                         context.applicationContext,
                         NoteDatabase::class.java,
                         "note_database"
                     ).build()
                     INSTANCE = instance
                     // return instance
                     instance
                 }
             }
         }
     }

