package com.example.jokeparcial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

//. El atributo jokeId almacena el Id que ofrece el
//proveedor de API en caso sea aplicable; content es el texto del chiste; rating es la calificación asignada
//por el usuario en estrellas; createdAt es la fecha y hora en que se registró el Joke
@Entity
class Joke (
    @PrimaryKey(autoGenerate = true)
    var jokeId: Int?,


    @ColumnInfo
    @SerializedName("joke")
    var joke: String="",

    @ColumnInfo
    var rating: Int=0,

    @ColumnInfo
    var createdAt: String=""

)