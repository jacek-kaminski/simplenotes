package com.jkcoding.simplenotesapp.feature_notes.presentation.note_list

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note
import com.jkcoding.simplenotesapp.feature_notes.presentation.note_list.components.NoteItem
import com.jkcoding.simplenotesapp.feature_notes.presentation.util.ScreenDestination
import com.jkcoding.simplenotesapp.ui.theme.DarkGrey

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteListScreen(
    navController: NavController,
    viewModel: NoteListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    NoteListScreenContent(
        noteList = state.notes,
        onAddNoteClick = { navController.navigate(route = ScreenDestination.AddEditNoteScreen.route) },
        onNoteClick = { note ->
            navController.navigate(ScreenDestination.AddEditNoteScreen.route + "?noteId=${note.id}")
        },
        onDeleteNoteClick = { note -> viewModel.onEvent(event = NoteListEvent.DeleteNote(note = note)) }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteListScreenContent(
    noteList: List<Note>,
    onAddNoteClick: () -> Unit,
    onNoteClick: (Note) -> Unit,
    onDeleteNoteClick: (Note) -> Unit,
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = DarkGrey,
                contentColor = Color.White,
                shape = CircleShape,
                onClick = onAddNoteClick,
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Notes",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.Black,
                )
                IconButton(
                    onClick = { },
                    content = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Sort,
                            contentDescription = "Sort",
                            tint = Color.Black,
                        )
                    },
                )
            }
            LazyColumn(
                contentPadding = PaddingValues(vertical = 16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(noteList) { note ->
                    NoteItem(
                        note = note,
                        modifier = Modifier.clickable(onClick = { onNoteClick(note) }),
                        onDeleteClick = { onDeleteNoteClick(note) }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}
