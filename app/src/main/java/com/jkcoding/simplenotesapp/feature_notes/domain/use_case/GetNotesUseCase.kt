package com.jkcoding.simplenotesapp.feature_notes.domain.use_case

import com.jkcoding.simplenotesapp.feature_notes.domain.repository.NotesRepository
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: NotesRepository,
) {
    suspend operator fun invoke() = repository.getNotes().toList()

}