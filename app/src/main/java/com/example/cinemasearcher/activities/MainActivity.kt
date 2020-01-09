package com.example.cinemasearcher.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemasearcher.R
import com.example.cinemasearcher.network.Movies
import com.example.cinemasearcher.recycler.RecyclerAdapter


class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    val KEY_TITLE = "title"
    val KEY_POSTER_URL = "poster"
    val KEY_YEAR = "year"
    val KEY_TYPE = "type"
    val KEY_IMDB = "imdbID"

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    var moviesAL: ArrayList<Movies> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.hasFixedSize()
        recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        getMovies()
    }

    fun getMovies(){

//        val moviesAPI = RetrofitService.start().getMovies()
//
//        moviesAPI.enqueue(object: Callback<List<Movies>> {
//            override fun onFailure(call: Call<List<Movies>>,
//                                   t: Throwable) {
//                result(Result.failure(call, t))
//            }
//
//            override fun onResponse(
//                call: Call<List<Movies>>,
//                response: Response<List<Movies>>
//            ) {
//
//            }
//        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val intent: Intent = Intent(this, Activity_Detail::class.java)

        val clickedMovie: Movies = moviesAL.get(position)

        intent.putExtra(KEY_TITLE, clickedMovie.title)
        intent.putExtra(KEY_IMDB, clickedMovie.imdbID)
        intent.putExtra(KEY_TYPE, clickedMovie.type)
        intent.putExtra(KEY_YEAR, clickedMovie.year)
        intent.putExtra(KEY_POSTER_URL, clickedMovie.poster)

        startActivity(intent)
    }
}







