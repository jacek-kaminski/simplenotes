package com.jkcoding.simplenotesapp.feature_notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    val color: Int,
    @PrimaryKey val id: Int? = null,
)