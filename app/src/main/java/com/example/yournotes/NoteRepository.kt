package com.example.yournotes

import androidx.lifecycle.LiveData

class NoteRepository (private val noteDao: NoteDao){

    // on below line we are creating a variable for our list
    // and we are getting all the notes from our DAO class.
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

   //for adding notes
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }
    //for deleting notes
    suspend fun delete(note: Note){
        noteDao.Delete(note)

    }
    //for updating notes
    suspend fun update(note: Note){
        noteDao.Update(note)
    }
}