package com.jkcoding.simplenotesapp.feature_notes.presentation.note_list

import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note

sealed class NoteListEvent {
    data object AddNote : NoteListEvent()
    data class DeleteNote(val note: Note) : NoteListEvent()
}