package com.jkcoding.simplenotesapp.feature_notes.presentation.note_list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NoteListScreen(
    navController: NavController,
    viewModel: NoteListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
    ) {

    }
}