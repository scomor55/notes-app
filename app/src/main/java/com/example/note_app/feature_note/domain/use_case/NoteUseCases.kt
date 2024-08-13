package com.example.note_app.feature_note.domain.use_case

data class NoteUseCases (
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote
)
