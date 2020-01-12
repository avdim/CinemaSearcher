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
import com.example.cinemasearcher.network.RetrofitService
import com.example.cinemasearcher.recycler.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    val KEY_TITLE = "title"
    val KEY_POSTER_URL = "poster"
    val KEY_YEAR = "year"
    val KEY_TYPE = "type"
    val KEY_IMDB = "imdbID"

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var moviesArrayList: ArrayList<Movies>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        getMovies()
    }

    private fun getMovies(){

        var moviesAPI = RetrofitService.start().getMovies()

        moviesAPI.enqueue(object: Callback<ArrayList<Movies>>{
            override fun onResponse(call: Call<ArrayList<Movies>>, response: Response<ArrayList<Movies>>) {

                moviesArrayList = response.body()!!
                recyclerAdapter = RecyclerAdapter(moviesArrayList, this@MainActivity)

            }
            override fun onFailure(call: Call<ArrayList<Movies>>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val intent: Intent = Intent(this, Activity_Detail::class.java)

        val clickedMovie: Movies = moviesArrayList.get(position)

        intent.putExtra(KEY_TITLE, clickedMovie.title)
        intent.putExtra(KEY_IMDB, clickedMovie.imdbID)
        intent.putExtra(KEY_TYPE, clickedMovie.type)
        intent.putExtra(KEY_YEAR, clickedMovie.year)
        intent.putExtra(KEY_POSTER_URL, clickedMovie.posterURL)

        startActivity(intent)
    }
}







