package com.example.yournotes

import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    fun insert(note:Note)

    @Delete
    fun Delete(note: Note)

    @Query(value = "SELECT * from NOTES_TABLE order by id ASC")
    fun getAllNotes(): List<Note>
}