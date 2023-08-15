package com.app.nupace.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user")
data class User (
    @PrimaryKey
    val email : String,
    val name : String,
    val password: String
) : Serializable