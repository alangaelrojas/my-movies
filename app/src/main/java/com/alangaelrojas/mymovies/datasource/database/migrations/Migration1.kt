package com.alangaelrojas.mymovies.datasource.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val migrationNewColumn = object : Migration(1, 2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Movies ADD COLUMN revenue INTEGER")
    }
}