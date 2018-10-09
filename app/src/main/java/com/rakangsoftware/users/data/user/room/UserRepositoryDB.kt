package com.rakangsoftware.users.data.user.room

import android.arch.lifecycle.LiveData
import com.rakangsoftware.users.data.user.User
import com.rakangsoftware.users.data.user.UserRepository
import com.rakangsoftware.users.utils.IO

class UserRepositoryDB(var userDao: UserDao) : UserRepository {

    override fun create(user: User) = IO.execute { userDao.insert(user) }

    override fun read(): LiveData<List<User>> = userDao.get()

    override fun update(user: User) = IO.execute { userDao.update(user) }

    override fun delete(user: User) = IO.execute { userDao.delete(user) }

}