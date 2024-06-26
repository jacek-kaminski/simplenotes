package com.jkcoding.simplenotesapp.feature_notes.presentation.add_edit_note

data class TextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true,
)
