package com.jkcoding.simplenotesapp.feature_notes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jkcoding.simplenotesapp.feature_notes.presentation.add_edit_note.AddEditNoteScreen
import com.jkcoding.simplenotesapp.feature_notes.presentation.note_list.NoteListScreen
import com.jkcoding.simplenotesapp.feature_notes.presentation.util.ScreenDestination
import com.jkcoding.simplenotesapp.ui.theme.SimpleNotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleNotesAppTheme {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenDestination.NoteListScreen.route,
                    ) {
                        composable(route = ScreenDestination.NoteListScreen.route) {
                            NoteListScreen(navController = navController)
                        }
                        composable(route = ScreenDestination.AddEditNoteScreen.route) {
                            AddEditNoteScreen(navController = navController)
                        }
                    }
            }
        }
    }
}
