package com.example.yournotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// on below line we are specifying our table name
@Entity(tableName = "notes_table")

// on below line we are specifying our column info
// and inside that we are passing our column name
class Note(@ColumnInfo(name = "text")val text: String) {

    // on below line we are specifying our key and
    // then auto generate as true and we are
    // specifying its initial value as 0
    @PrimaryKey(autoGenerate = true) var id = 0
}