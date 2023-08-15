package com.app.nupace.domain

import androidx.lifecycle.LiveData
import com.app.nupace.data.User
import com.app.nupace.data.UserDao

class UserRepository(private val userDao: UserDao){
    suspend fun addUser(user: User) = userDao.addUser(user)
    fun getUserByEmail(email : String): LiveData<List<User>> {
        return userDao.getUserByEmail(email)
    }
}