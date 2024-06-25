package com.jkcoding.simplenotesapp.feature_notes.presentation.note_list

sealed class NoteListEvent {
    data object AddNote : NoteListEvent()
}