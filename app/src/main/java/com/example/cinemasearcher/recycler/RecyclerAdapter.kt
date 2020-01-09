package com.example.cinemasearcher.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemasearcher.R
import com.example.cinemasearcher.network.Movies
import com.squareup.picasso.Picasso


class RecyclerAdapter(val moviesAL: ArrayList<Movies>,
                      val context: Context
) : RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item4recycler, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = moviesAL.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie: Movies = moviesAL.get(position)

        var title: String = currentMovie.title
        var year: Int = currentMovie.year
        var imdbID: Int = currentMovie.imdbID
        var type: String = currentMovie.type
        var URLposter: String = currentMovie.poster

        holder.title
        holder.imdb
        holder.type
        holder.year

        Picasso.get().load(URLposter).fit().centerInside().into(holder.poster)

    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val poster: ImageView = itemView.findViewById(R.id.poster)
        val type: TextView = itemView.findViewById(R.id.tvType)
        val year: TextView = itemView.findViewById(R.id.tvYear)
        val imdb: TextView = itemView.findViewById(R.id.tvimdb)

    }
}