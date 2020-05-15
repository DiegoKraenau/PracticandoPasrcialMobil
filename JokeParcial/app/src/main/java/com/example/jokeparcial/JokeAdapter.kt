package com.example.jokeparcial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_joke.view.*

class JokeAdapter(private val jokes: List<Joke>,private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<JokePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokePrototype {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.prototype_joke, parent, false)
        return JokePrototype(view)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: JokePrototype, position: Int) {
        holder.bind(jokes[position], itemClickListener)
    }

}

class JokePrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textoJoke = itemView.textJoke
    private val textoRaiting = itemView.textoRaiting
    private val textFecha = itemView.textDate
    private val cvJoke=itemView.cvJoke


    fun bind(joke: Joke, itemClickListener: OnItemClickListener) {
        textoJoke.text = joke.joke
        textoRaiting.text = joke.rating.toString()
        textFecha.text=joke.createdAt

        cvJoke.setOnClickListener {
            itemClickListener.onItemClicked(joke)
        }
    }


}

interface OnItemClickListener {
    fun onItemClicked(joke: Joke)
}
