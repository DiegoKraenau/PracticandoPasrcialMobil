package com.example.jokeparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var listaJokes:List<Joke>


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeService: JokeService
        jokeService = retrofit.create(JokeService::class.java)

        val request = jokeService.getJoke("json")

        request.enqueue(object : Callback<Joke>{
            override fun onFailure(call: Call<Joke>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful) {
                    textJoke.text = response.body()!!.joke


                    var jokeOriginal=Joke(null,response.body()!!.joke,3,"aea")
                    AppDatabase.getInstance(this@MainActivity).getDao().insertJoke(jokeOriginal)
                    listaJokes=AppDatabase.getInstance(this@MainActivity).getDao().getAll()


                }
            }

        })

        btnJoke.setOnClickListener {
            //Toast.makeText(this, listaJokes.size.toString(),Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListarJokes::class.java)
            startActivity(intent)
        }

    }



}
