package com.example.note_app.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.note_app.ui.BabyBlue
import com.example.note_app.ui.LightGreen
import com.example.note_app.ui.RedOrange
import com.example.note_app.ui.RedPink
import com.example.note_app.ui.Violet

@Entity(tableName = "note")
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
) {
    companion object{
       val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}


class InvalidNoteException(message: String): Exception(message)
