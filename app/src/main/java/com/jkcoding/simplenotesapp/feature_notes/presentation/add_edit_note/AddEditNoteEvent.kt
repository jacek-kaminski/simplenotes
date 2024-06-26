package com.jkcoding.simplenotesapp.feature_notes.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

sealed interface AddEditNoteEvent {
    data class EnteredTitle(val value: String): AddEditNoteEvent
    data class ChangeTitleFocus(val focusState: FocusState): AddEditNoteEvent
    data class EnteredContent(val value: String): AddEditNoteEvent
    data class ChangeContentFocus(val focusState: FocusState): AddEditNoteEvent
    data object SaveNote: AddEditNoteEvent
}