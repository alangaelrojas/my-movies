package com.alangaelrojas.mymovies.datasource.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * El objeto Migration nos permitira crear sentencias de SQL para modificar aspectos de nuestra base de datos
 * SQLite usando Room, estos son mandados llamar en el momento que se instancia nuestra base de datos de Room
 * y se ejecutaran segun los parametros del objeto Migration (currentVersion, newVersion)
 * @see androidx.room.migration.Migration
 * **/
val migrationNewColumn = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Movies ADD COLUMN revenue INTEGER")
    }
}