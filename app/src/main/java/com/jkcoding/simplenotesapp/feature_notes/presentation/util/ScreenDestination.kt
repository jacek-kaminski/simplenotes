package com.jkcoding.simplenotesapp.feature_notes.presentation.util

sealed class ScreenDestination(val route: String) {
    data object NoteListScreen : ScreenDestination(route = "note_list_screen")
    data object AddEditNoteScreen : ScreenDestination(route = "add_edit_note_screen")
}