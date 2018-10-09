package com.rakangsoftware.users.data.user.firestore

import android.arch.lifecycle.LiveData

import com.google.firebase.firestore.*
import com.rakangsoftware.users.data.user.User

class UsersLiveDataFS : LiveData<List<User>>() {

    private val reference = FirebaseFirestore
            .getInstance()
            .collection("users")

    private var registration: ListenerRegistration? = null

    private val eventListener = EventListener<QuerySnapshot> { documentSnapshots, exception ->
        postValue(documentSnapshots?.documents?.map { it.toObject(User::class.java) }?.filterNotNull()
                ?: arrayListOf())
    }

    override fun onActive() {
        registration = reference.addSnapshotListener(eventListener)
    }

    override fun onInactive() {
        registration?.remove()
        registration = null
    }
}

