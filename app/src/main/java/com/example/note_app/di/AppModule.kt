package com.example.note_app.di

import android.app.Application
import androidx.room.Room
import com.example.note_app.feature_note.data.data_source.NoteDao
import com.example.note_app.feature_note.data.data_source.NoteDatabase
import com.example.note_app.feature_note.data.repository.NoteRepositoryImplementation
import com.example.note_app.feature_note.domain.repository.NoteRepository
import com.example.note_app.feature_note.domain.use_case.AddNote
import com.example.note_app.feature_note.domain.use_case.DeleteNote
import com.example.note_app.feature_note.domain.use_case.GetNotes
import com.example.note_app.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImplementation(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}