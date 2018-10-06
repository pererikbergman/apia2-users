package com.rakangsoftware.users.data.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        @ColumnInfo(name = "first_name") var firstName: String = "",
        @ColumnInfo(name = "last_name") var lastName: String = "",
        @ColumnInfo(name = "fb_id") var fbId: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Long = 0

}