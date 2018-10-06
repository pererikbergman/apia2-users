package com.rakangsoftware.users.data

import android.content.Context
import com.rakangsoftware.users.data.user.UserRepository
import com.rakangsoftware.users.data.user.UserRepositoryDB
import com.rakangsoftware.users.data.user.UserRepositoryFB

class RepositoryFactory {
    companion object {

        private var sUserRepository: UserRepository? = null

        @JvmStatic
        @Synchronized
        fun getUserRepository(context: Context): UserRepository {
            if (sUserRepository == null) {
                sUserRepository = UserRepositoryFB()
            }
            return sUserRepository as UserRepository
        }

    }
}