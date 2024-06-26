package com.jkcoding.simplenotesapp.feature_notes.presentation.note_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note
import com.jkcoding.simplenotesapp.feature_notes.domain.use_case.AddNoteUseCase
import com.jkcoding.simplenotesapp.feature_notes.domain.use_case.DeleteNoteUseCase
import com.jkcoding.simplenotesapp.feature_notes.domain.use_case.GetNotesUseCase
import com.jkcoding.simplenotesapp.ui.theme.LightOrange
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val getNotesUseCase: GetNotesUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(value = NoteListState())
    val state = _state.asStateFlow()

    private var getNotesJob: Job? = null

    init {
        getNotes()
    }

    fun onEvent(event: NoteListEvent) {
        when (event) {
            NoteListEvent.AddNote -> viewModelScope.launch {
                addNoteUseCase(
                    note = Note(
                        title = "Note test",
                        content = "Note content",
                        color = LightOrange.hashCode(),
                    )
                )
            }

            is NoteListEvent.DeleteNote -> viewModelScope.launch {
                deleteNoteUseCase(
                    note = event.note
                )
            }
        }
    }

    private fun getNotes() {
        getNotesJob?.cancel()
        getNotesJob = getNotesUseCase()
            .onEach { notes -> _state.value = state.value.copy(notes = notes) }
            .launchIn(viewModelScope)
    }
}