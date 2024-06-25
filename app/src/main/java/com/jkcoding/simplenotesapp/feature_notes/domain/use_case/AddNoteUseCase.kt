package com.jkcoding.simplenotesapp.feature_notes.domain.use_case

import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note
import com.jkcoding.simplenotesapp.feature_notes.domain.repository.NotesRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: NotesRepository,
) {
    suspend operator fun invoke(note: Note) = repository.insertNote(note = note)
}