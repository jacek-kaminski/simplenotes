package com.jkcoding.simplenotesapp.feature_notes.presentation.note_list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note
import com.jkcoding.simplenotesapp.ui.theme.DarkGrey
import com.jkcoding.simplenotesapp.ui.theme.LightGreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                containerColor = DarkGrey,
                contentColor = Color.White,
                onClick = {
                    viewModel.onEvent(event = NoteListEvent.AddNote)
                },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = DarkGrey)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Notes",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.White,
                )
                IconButton(
                    onClick = { },
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = Color.White,
                        )
                    },
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.notes) { note ->
                    NoteItem(
                        note = note,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun NoteItem(
    note: Note,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(note.color)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = note.title,
            style = MaterialTheme.typography.headlineSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Start,
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = note.content,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Start,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }
}

@Preview
@Composable
fun NoteItemPreview() {
    NoteItem(
        note = Note(
            title = "Title no. 1",
            content = "Content no. 1 \nline 2 \nline3 \nline4 \nline5 \nline6",
            color = LightGreen.hashCode(),
        )
    )
}
