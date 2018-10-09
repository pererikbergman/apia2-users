package com.rakangsoftware.users.data

import android.content.Context
import com.rakangsoftware.users.data.user.UserRepository
import com.rakangsoftware.users.data.user.firestore.UserRepositoryFS

class RepositoryFactory {
    companion object {

        private var sUserRepository: UserRepository? = null

        @JvmStatic
        @Synchronized
        fun getUserRepository(context: Context): UserRepository {
            if (sUserRepository == null) {
                sUserRepository = UserRepositoryFS()
            }
            return sUserRepository as UserRepository
        }

    }
}