package com.jkcoding.simplenotesapp.feature_notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jkcoding.simplenotesapp.ui.theme.LightBlue
import com.jkcoding.simplenotesapp.ui.theme.LightGreen
import com.jkcoding.simplenotesapp.ui.theme.LightOrange
import com.jkcoding.simplenotesapp.ui.theme.LightRed
import com.jkcoding.simplenotesapp.ui.theme.LightYellow

@Entity
data class Note(
    val title: String,
    val content: String,
    val color: Int,
    @PrimaryKey val id: Int? = null,
) {
    companion object {
        val noteColors = listOf(LightRed, LightOrange, LightYellow, LightGreen, LightBlue)
    }
}