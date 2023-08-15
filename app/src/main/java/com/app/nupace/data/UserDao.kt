package com.app.nupace.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    // Insert new User
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)
    // Recover user by email
    @Query("SELECT * FROM User WHERE email = :email")
    fun getUserByEmail(email: String): LiveData<List<User>>
}