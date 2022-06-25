package com.example.yournotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.file.Files.delete

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    //  creating a variable for our all notes list and repository
    val allNotes: LiveData<List<Note>>
    private val repository: NoteRepository

    // on below line we are initializing
    // our dao, repository and all notes
    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
        fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
            repository.insert(note)
    }
    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.update(note)
    }
}
