package com.example.jokeparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_listar_jokes.*

class ListarJokes : AppCompatActivity(),OnItemClickListener {

    companion object{
        lateinit var jokeElegido:Joke
    }

    override fun onItemClicked(joke: Joke) {
        jokeElegido=joke
        val intent = Intent(this, JokeElegido::class.java)
        startActivity(intent)
    }

    private lateinit var jokes: List<Joke>
    private lateinit var jokeAdapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_jokes)

        jokes=MainActivity.listaJokes

        //Toast.makeText(this,jokes.size.toString(),Toast.LENGTH_SHORT).show()
        jokeAdapter= JokeAdapter(jokes,this)

        rvJokes.adapter=jokeAdapter
        rvJokes.layoutManager = LinearLayoutManager(this)


    }
}
