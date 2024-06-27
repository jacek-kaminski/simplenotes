package com.jkcoding.simplenotesapp.feature_notes.presentation.note_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkcoding.simplenotesapp.feature_notes.domain.model.Note
import com.jkcoding.simplenotesapp.ui.theme.LightGreen

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note: Note,
    onDeleteClick: () -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(note.color)),
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation()
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
        IconButton(
            onClick = onDeleteClick,
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun NoteItemPreview() {
    NoteItem(
        onDeleteClick = {},
        note = Note(
            title = "Some note about important things",
            content = "This is the content of this important note.",
            color = LightGreen.hashCode(),
        )
    )
}