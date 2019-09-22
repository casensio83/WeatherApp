package com.example.weatherapp4.database

import android.content.Context
import android.os.AsyncTask
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(LocationEntity::class), version = 1)
abstract class LocationRoomDatabase: RoomDatabase() {

    abstract fun locationDao(): LocationDao

    companion object {
        // marking the instance as volatile to ensure atomic access to the variable
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
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
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
         * For this sample, we clear the database every time it is created or opened.
         *
         * If you want to populate the database only when the database is created for the 1st time,
         * override RoomDatabase.Callback()#onCreate
         */
        val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(@NonNull db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                PopulateDbAsync(DB_INSTANCE!!).execute()
            }
        }
    }

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private class PopulateDbAsync internal constructor(db: LocationRoomDatabase) : AsyncTask<Void, Void, Void>() {

        private val mDao: LocationDao

        init {
            mDao = db.locationDao()
        }

        override fun doInBackground(vararg params: Void): Void? {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll()

            var location = LocationEntity("Malaga", "Spain")
            mDao.insert(location)
            location = LocationEntity("Valencia", "Spain")
            mDao.insert(location)
            return null
        }
    }
}