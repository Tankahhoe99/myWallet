package com.example.mywallet

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = arrayOf(InOutLog::class), version = 1)
abstract class InOutLgDatabase : RoomDatabase(){
    //Ensure only one instance of the database is created
    abstract fun inOutLogDao(): InOutLogDao

    companion object {
        @Volatile
        private var INSTANCE: InOutLgDatabase? = null

        fun getDatabase(context: Context): InOutLgDatabase {
            val tempDB = INSTANCE
            if (tempDB != null) {
                return tempDB
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InOutLgDatabase::class.java,
                    "inoutlog_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}