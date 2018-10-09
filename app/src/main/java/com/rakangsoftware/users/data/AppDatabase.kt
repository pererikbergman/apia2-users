package com.rakangsoftware.users.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.rakangsoftware.users.data.user.User
import com.rakangsoftware.users.data.user.room.UserDao

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "database.db"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroy() {
            INSTANCE = null
        }
    }


}