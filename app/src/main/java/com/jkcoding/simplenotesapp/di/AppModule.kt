package com.jkcoding.simplenotesapp.di

import android.app.Application
import androidx.room.Room
import com.jkcoding.simplenotesapp.feature_notes.data.data_source.NotesDatabase
import com.jkcoding.simplenotesapp.feature_notes.data.repository.NotesRepositoryImpl
import com.jkcoding.simplenotesapp.feature_notes.domain.repository.NotesRepository
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
    fun provideNotesDatabase(app: Application): NotesDatabase =
        Room.databaseBuilder(
            app,
            NotesDatabase::class.java,
            NotesDatabase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideNotesRepository(database: NotesDatabase): NotesRepository {
        return NotesRepositoryImpl(notesDao = database.notesDao)
    }
}