package com.app.nupace.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.nupace.data.AppDataBase
import com.app.nupace.data.User
import com.app.nupace.domain.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository
    init {
        val userDao = AppDataBase.getInstance(application).userDao()
        userRepository = UserRepository(userDao)
    }
    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.addUser(user)
        }
    }
    fun getUserByEmail(email: String){
        viewModelScope.launch {
            userRepository.getUserByEmail(email)
        }
    }
}