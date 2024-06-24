package com.jkcoding.simplenotesapp.feature_notes.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1,
)
abstract class NotesDatabase: RoomDatabase() {
    abstract val notesDao: NotesDao

    companion object {
        const val DATABASE_NAME = "NOTES_DB"
    }
}