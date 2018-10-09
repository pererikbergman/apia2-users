package com.rakangsoftware.users.data.user.firestore

import android.arch.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.rakangsoftware.users.data.user.User
import com.rakangsoftware.users.data.user.UserRepository

class UserRepositoryFS : UserRepository {

    private val reference = FirebaseFirestore
            .getInstance()
            .collection("users")


    override fun create(user: User) {
        user.fbId = reference.document().id
        reference.document(user.fbId).set(user) // overwritten
    }

    override fun read(): LiveData<List<User>> {
        return UsersLiveDataFS()
    }

    override fun update(user: User) {
        reference.document(user.fbId).set(user, SetOptions.merge())
    }

    override fun delete(user: User) {
        reference.document(user.fbId).delete()
    }
}