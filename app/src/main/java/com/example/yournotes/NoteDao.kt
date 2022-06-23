package com.example.yournotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {


    // below is the insert method for
    // adding a new entry to our database.
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    fun insert(note:Note)

    @Delete
    fun Delete(note: Note)

    // below is the method to read all the notes
    // from our database we have specified the query for it.
    // inside the query we are arranging it in ascending
    // order on below line and we are specifying
    // the table name from which
    // we have to get the data.
    @Query(value = "SELECT * from NOTES_TABLE order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}