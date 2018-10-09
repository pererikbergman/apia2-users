package com.rakangsoftware.users.data.user.realtime

import android.arch.lifecycle.LiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rakangsoftware.users.data.user.User
import com.rakangsoftware.users.data.user.UserRepository

class UserRepositoryFB : UserRepository {

    private val reference: DatabaseReference = FirebaseDatabase
            .getInstance()
            .getReference("users")

    override fun create(user: User) {
        val key = reference.push().key
        key?.let {
            user.fbId = key
            reference.child(it).setValue(user)
        }
    }

    override fun read(): LiveData<List<User>> {
        return UsersLiveData()
    }

    override fun update(user: User) {
        reference.child(user.fbId).setValue(user)
    }

    override fun delete(user: User) {
        reference.child(user.fbId).removeValue()
    }
}