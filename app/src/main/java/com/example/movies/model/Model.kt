package com.example.movies.model

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.movies.api.RequestQueueSingleton
import org.json.JSONArray

class Model(context : Context) {
    private val context : Context
    val moviesData : MutableList<Movie>

    data class Actor(val actorName : String, val characterName: String)

    data class Movie(val id : String, val title : String, val released : String, val plot : String, val genre : List<String>,
                     val playtime : String, val director : String, val cost : String, val profit : String, val cast : List<Actor>, val poster : String) {
    }

    init {
        this.context = context
        this.moviesData = mutableListOf<Movie>()
        fetchAllMovie()
    }


    private fun fetchAllMovie() {
        val queue = Volley.newRequestQueue(this.context)
        val url = "https://syadon-android-movies.glitch.me/movie/all"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            {  response ->
                val temp : JSONArray = response
                for(i in 0 until temp.length()) {
                    val movieJSON = temp.getJSONObject(i)
                    val tempCast = movieJSON.getJSONArray("cast")
                    val cast = mutableListOf<Actor>()
                    for(j in 0 until tempCast.length()) {
                        val actorJSON = tempCast.getJSONObject(j)
                        cast.add(Actor(actorName=actorJSON.get("actorName").toString(),
                            characterName=actorJSON.get("characterName").toString()))
                    }
                    val tempGenre = movieJSON.getJSONArray("genre")
                    val genre = mutableListOf<String>()
                    for(k in 0 until tempGenre.length()) {
                        genre.add(tempGenre.getString(k))
                    }

                    moviesData.add(Movie(id=movieJSON.get("_id").toString(),
                    title=movieJSON.get("title").toString(),
                    released=movieJSON.get("released_year").toString(),
                    plot=movieJSON.get("plot").toString(),
                    genre=genre,
                    playtime=movieJSON.get("playtime").toString(),
                    director=movieJSON.get("director").toString(),
                    cost=movieJSON.get("cost").toString(),
                    profit=movieJSON.get("profit").toString(),
                    cast=cast,
                    poster=movieJSON.get("poster").toString()
                    ))
                }
                Log.d("pop", moviesData.toString())
            },
            {
                //TODO: Handle error
            }
        )
        RequestQueueSingleton.getInstance(this.context).addToRequestQueue(jsonArrayRequest)
    }





/*    //Asset könyvtárból csv fájl kiolvasása sorról sorra
    private fun readCsv() : MutableList<Movie>  {
        val reader =  this.context.assets.open(resFileName).bufferedReader()
        var lines : MutableList<Movie> = mutableListOf<Movie>()
        val header : String = reader.readLine() //header
        val data = reader.readLines()

        if(BuildConfig.DEBUG) {
            Log.d("header", header)
            Log.d("data", data[0])
        }

        data.forEachIndexed { index, line ->
            val row : List<String> = line.split(';')
            lines.add(Movie(index, row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]))
        }
        return lines
    }*/

/*    //Kezdetleges filmlista szűréshez
    fun getFilteredMovies(filter : String) : List<Movie> {
        val filteredData = this.moviesData.filter {
            it.title.lowercase().contains(filter) || it.director.lowercase().contains(filter)
                    || it.genre.lowercase().contains(filter)
        }
       return filteredData.ifEmpty { listOf() }
    }*/
}


