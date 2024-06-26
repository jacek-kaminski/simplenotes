package com.jkcoding.simplenotesapp.feature_notes.presentation.add_edit_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note
import com.jkcoding.simplenotesapp.feature_notes.domain.use_case.AddNoteUseCase
import com.jkcoding.simplenotesapp.feature_notes.domain.use_case.DeleteNoteUseCase
import com.jkcoding.simplenotesapp.feature_notes.domain.use_case.GetNotesUseCase
import com.jkcoding.simplenotesapp.feature_notes.presentation.note_list.NoteListState
import com.jkcoding.simplenotesapp.ui.theme.LightOrange
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
) : ViewModel() {

    private val _noteTitleState =
        MutableStateFlow(value = TextFieldState(hint = "Enter note title"))
    val noteTitleState = _noteTitleState.asStateFlow()

    private val _noteContentState =
        MutableStateFlow(value = TextFieldState(hint = "Enter note content"))
    val noteContentState = _noteContentState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null
    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.EnteredTitle -> {
                _noteTitleState.value = noteTitleState.value.copy(
                    text = event.value
                )
            }

            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitleState.update {
                    it.copy(isHintVisible = !event.focusState.isFocused && noteTitleState.value.text.isBlank())
                }
            }

            is AddEditNoteEvent.EnteredContent -> {
                _noteContentState.update {
                    it.copy(text = event.value)
                }
            }

            is AddEditNoteEvent.ChangeContentFocus -> {
                _noteContentState.value = noteContentState.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteContentState.value.text.isBlank()
                )
            }

            is AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    addNoteUseCase(
                        note = Note(
                            title = noteTitleState.value.text,
                            content = noteContentState.value.text,
                            color = Note.noteColors.random().hashCode(),
                            id = currentNoteId
                        )
                    )
                    _eventFlow.emit(UiEvent.SaveNote)
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveNote : UiEvent()
    }

}