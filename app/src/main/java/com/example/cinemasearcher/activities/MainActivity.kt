package com.example.cinemasearcher.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemasearcher.R
import com.example.cinemasearcher.network.Movies
import com.example.cinemasearcher.network.RetrofitService
import com.example.cinemasearcher.recycler.RecyclerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(){

    val KEY_TITLE = "title"
    val KEY_POSTER_URL = "poster"
    val KEY_YEAR = "year"
    val KEY_TYPE = "type"
    val KEY_IMDB = "imdbID"

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


        responseFromAPI()

    }

    private fun responseFromAPI() {

        var call = RetrofitService.start().getMovies()


        call.enqueue(object : Callback<ArrayList<Movies>> {
            override fun onResponse(
                call: Call<ArrayList<Movies>>,
                response: Response<ArrayList<Movies>>
            ) {

                if (response.isSuccessful) {
                    var moviesArrayList: ArrayList<Movies> = response.body()!!
                    recyclerAdapter = RecyclerAdapter(moviesArrayList, this@MainActivity)
                    recyclerView.adapter = recyclerAdapter

                }
                if (!response.isSuccessful) {
                    print(response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<ArrayList<Movies>>, t: Throwable) {

                t.printStackTrace()
                Toast.makeText(this@MainActivity, "Произошла ошибка", Toast.LENGTH_LONG).show()

            }
        })


        //        var call = RetrofitService.start().getMovies()
//            .subscribeOn(Schedulers.io())
//            .unsubscribeOn(Schedulers.io())
//                // данные обрабатываются подписчиком в mainTread
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ it ->
//                Log.d("size", it.size.toString())
//                setDataInRecyclerView(it = )
//            }, { it ->
//                Log.d("error", "error")
//            })
//    }
//    private fun setDataInRecyclerView(it: ArrayList<Movies>?) {
//        recyclerView.adapter = RecyclerAdapter(it!!,this)
//    }
    }
}
//
//    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//
//        val intent = Intent(this, Activity_Detail::class.java)
//
//        val clickedMovie: Movies = moviesArrayList.get(position)
//
//        intent.putExtra(KEY_TITLE, clickedMovie.title)
//        intent.putExtra(KEY_IMDB, clickedMovie.imdbID)
//        intent.putExtra(KEY_TYPE, clickedMovie.type)
//        intent.putExtra(KEY_YEAR, clickedMovie.year)
//        intent.putExtra(KEY_POSTER_URL, clickedMovie.posterURL)
//
//        startActivity(intent)
//
//    }
//}







