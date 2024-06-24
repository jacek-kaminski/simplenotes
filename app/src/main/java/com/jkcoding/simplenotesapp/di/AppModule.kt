package com.jkcoding.simplenotesapp.di

import android.app.Application
import com.jkcoding.simplenotesapp.feature_notes.data.data_source.NotesDatabase
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
    fun provideNotesDatabase(app: Application): NotesDatabase {

    }
}