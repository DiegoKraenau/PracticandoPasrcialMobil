package com.example.jokeparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_joke_elegido.*

class JokeElegido : AppCompatActivity() {
    companion object{
        var numero:Int=0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_elegido)

        var lblJoek=findViewById<EditText>(R.id.lblJoke)

        lblJoek.setText(ListarJokes.jokeElegido.joke)

        ratingJoke.rating=ListarJokes.jokeElegido.rating.toFloat()


        ratingJoke.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            numero=rating.toInt()
        }



        modificarJoke.setOnClickListener {
            ListarJokes.jokeElegido.joke=lblJoek.text.toString()
            ListarJokes.jokeElegido.rating= numero

            AppDatabase.getInstance(this).getDao().updateJoke(ListarJokes.jokeElegido)

            Toast.makeText(this,"Se modifico.",Toast.LENGTH_SHORT).show()

        }


    }
}
