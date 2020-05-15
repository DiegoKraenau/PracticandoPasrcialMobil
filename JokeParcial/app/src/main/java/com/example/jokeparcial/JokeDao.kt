package com.example.jokeparcial

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface JokeDao {

    @Query("SELECT * FROM Joke")
    fun getAll():List<Joke>

    @Insert
    fun insertJoke(vararg jokes:Joke)

    @Update
    fun updateJoke(vararg  jokes:Joke)

}