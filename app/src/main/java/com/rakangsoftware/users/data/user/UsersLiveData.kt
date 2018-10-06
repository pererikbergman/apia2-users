package com.rakangsoftware.users.data.user

import android.arch.lifecycle.LiveData

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UsersLiveData() : LiveData<List<User>>() {

    private val reference: DatabaseReference = FirebaseDatabase
            .getInstance()
            .getReference("users")

    private val eventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            println("onDataChange")
            value = dataSnapshot.children.mapNotNull {
                it.getValue(User::class.java)
            }
        }

        override fun onCancelled(databaseError: DatabaseError) {
            println("onCancelled")
        }
    }

    override fun onActive() {
        println("onActive")
        reference.addValueEventListener(eventListener)
    }

    override fun onInactive() {
        println("onInactive")
        reference.removeEventListener(eventListener)
    }
}

