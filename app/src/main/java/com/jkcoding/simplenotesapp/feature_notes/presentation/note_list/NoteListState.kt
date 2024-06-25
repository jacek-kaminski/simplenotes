package com.jkcoding.simplenotesapp.feature_notes.presentation.note_list

import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
)
