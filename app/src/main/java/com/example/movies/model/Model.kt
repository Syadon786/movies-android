package com.example.movies.model

import android.content.Context
import android.util.Log
import com.example.movies.BuildConfig

class Model(context : Context) {
    private val resFileName : String = "movies.csv"
    private val context : Context
    val moviesData : MutableList<Movie>

    //Nested data class, ami egy movie adatait reprezentálja

    data class Movie(val id : Int, val title : String, val released : String, val plot : String, val genre : String,
                     val playtime : String, val director : String, val cost : String, val profit : String, val cast : String, val poster : String) {
    }

    //Context attribútum inicializálása a konstruktorban paraméterként kapott application contexttel
    //moviesData feltöltése a filmek adataival, minden egyes film adatai egy Movie osztály valósít meg
    init {
        this.context = context
        this.moviesData = readCsv()

        if(BuildConfig.DEBUG) {
           val msg : String = "Movie data after readCsv: $moviesData"
            Log.d("moviesData", msg)
        }
    }

    //Asset könyvtárból csv fájl kiolvasása sorról sorra
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
    }

}


