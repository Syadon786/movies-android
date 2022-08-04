package com.example.movies.controller

import android.content.Context
import com.example.movies.model.Model

class Controller(context : Context) {
    private val model : Model
    private val context : Context
    init {
        this.context = context
        this.model = Model(context)
    }

    fun getMovieData(id : Int) : Model.Movie {
        return Model.Movie(
                this.model.moviesData[id].id,
                model.moviesData[id].title,
                model.moviesData[id].released,
                model.moviesData[id].plot,
                model.moviesData[id].genre,
                model.moviesData[id].playtime,
                model.moviesData[id].director,
                model.moviesData[id].cost,
                model.moviesData[id].profit,
                model.moviesData[id].cast,
                model.moviesData[id].poster
        )
    }

    fun getMovieTitle(id : Int) : String {
        return this.model.moviesData[id].title
    }

    fun getMovieReleasedDate(id : Int) : String {
        return this.model.moviesData[id].released
    }

    fun getMoviePlot(id : Int) : String {
        return this.model.moviesData[id].plot
    }

    fun getMovieGenres(id : Int) : List<String> {
        return this.model.moviesData[id].genre.replace(" ", "").split(",")
    }

    fun getMoviePlayTime(id : Int) : String {
        return this.model.moviesData[id].playtime
    }

    fun getMovieDirector(id : Int) : String {
        return this.model.moviesData[id].director
    }

    fun getMovieCost(id : Int) : String {
        return this.model.moviesData[id].cost
    }

    fun getMovieProfit(id : Int) : String {
        return this.model.moviesData[id].profit
    }

    fun getMovieCast(id : Int) : MutableList<Pair<String, String>> {
        var castInfo : MutableList<Pair<String, String>> = mutableListOf()
        val actors = this.model.moviesData[id].cast.split(',')
        for(actor in actors) {
            val temp = actor.split("#")
            castInfo.add(Pair(temp[0], temp[1]))
        }
        return castInfo
    }

    fun getPosterName(id : Int) : String  {
        return this.model.moviesData[id].poster
    }

    fun getMoviesCount() : Int {
        return this.model.moviesData.count()
    }
}