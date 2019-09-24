package com.example.weatherapp5.database

import android.content.Context
import android.os.AsyncTask
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [LocationEntity::class], version = 1, exportSchema = false)
abstract class LocationRoomDatabase : RoomDatabase() {

    abstract fun locationDao(): LocationDao

    companion object {
        @Volatile
        var DB_INSTANCE: LocationRoomDatabase? = null

        fun getDatabase(context: Context): LocationRoomDatabase? {
            if (DB_INSTANCE == null) {
                synchronized(LocationRoomDatabase::class.java) {
                    if (DB_INSTANCE == null) {
                        DB_INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            LocationRoomDatabase::class.java, "word_database"
                        )
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build()
                    }
                }
            }
            return DB_INSTANCE
        }

        /**
         * Override the onOpen method to populate the database.
         *
         */
        private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(@NonNull db: SupportSQLiteDatabase) {
                super.onOpen(db)
                //PopulateDbAsync(DB_INSTANCE!!).execute()
            }
        }
    }

    private class PopulateDbAsync internal constructor(db: LocationRoomDatabase) : AsyncTask<Void, Void, Void>() {

        private val mDao: LocationDao = db.locationDao()

        override fun doInBackground(vararg params: Void): Void? {
            // Start the app with a clean database every time.
            mDao.deleteAll()

            var location = LocationEntity("Tokyo", "Japan")
            mDao.insert(location)
            location = LocationEntity("Barcelona", "Spain")
            mDao.insert(location)
            return null
        }
    }
}