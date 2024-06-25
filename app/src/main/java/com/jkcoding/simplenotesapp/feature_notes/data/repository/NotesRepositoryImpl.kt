package com.jkcoding.simplenotesapp.feature_notes.data.repository

import com.jkcoding.simplenotesapp.feature_notes.data.data_source.NotesDao
import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note
import com.jkcoding.simplenotesapp.feature_notes.domain.repository.NotesRepository

class NotesRepositoryImpl(
    private val notesDao: NotesDao
) : NotesRepository {
    override fun getNotes() = notesDao.getNotes()

    override suspend fun getNoteById(id: Int) = notesDao.getNoteById(id = id)

    override suspend fun insertNote(note: Note) = notesDao.insertNote(note = note)

    override suspend fun deleteNote(note: Note) = notesDao.deleteNote(note = note)
}